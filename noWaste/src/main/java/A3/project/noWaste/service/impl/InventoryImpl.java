package A3.project.noWaste.service.impl;

import A3.project.noWaste.domain.Inventory;
import A3.project.noWaste.domain.User;
import A3.project.noWaste.dto.InventoryDTO;
import A3.project.noWaste.infra.InventoryRepository;
import A3.project.noWaste.infra.UserRepository;
import A3.project.noWaste.service.InventoryService;
import A3.project.noWaste.exceptions.DataIntegratyViolationException;
import A3.project.noWaste.exceptions.ObjectNotFoundException;
import A3.project.noWaste.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryImpl implements InventoryService {

    @Autowired
    private InventoryRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private VerificationService verificationService;



    // Listar todos os inventários
    @Override
    public List<Inventory> findAll() {
        Integer userId = verificationService.pegarIdUsuario();
        return repository.findByUserId(userId);
    }

    // Criar inventário
    @Override
    public Inventory create(InventoryDTO obj) {
        User user = verificationService.verifyUser();
        checkInventoryName(obj);

        Inventory inventory = mapper.map(obj, Inventory.class);
        inventory.setUser(user);
        return repository.save(inventory);
    }

    // Atualizar inventário
    @Override
    public Inventory update(InventoryDTO obj) {
        Integer userId = verificationService.pegarIdUsuario();

        Inventory upInventory = repository.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Inventário não encontrado"));

        if (!upInventory.getUser().getId().equals(userId)) {
            throw new DataIntegratyViolationException("Acesso negado");
        }

        checkInventoryName(obj);
        upInventory.setName(obj.getName());
        return repository.save(upInventory);
    }

    // Deletar inventário
    @Override
    public void delete(Integer id) {
        Integer userId = verificationService.pegarIdUsuario();

        Inventory inventory = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Inventário não encontrado"));

        if (!inventory.getUser().getId().equals(userId)) {
            throw new DataIntegratyViolationException("Acesso negado");
        }
        repository.delete(inventory);
    }

    //-----------------------------------------------------------------------------

    // Verifica duplicidade de nome do inventário para o mesmo usuário
    private void checkInventoryName(InventoryDTO obj) {
        Integer userId = verificationService.pegarIdUsuario();
        Optional<Inventory> inv = repository.findAll().stream()
                .filter(i -> i.getName().equalsIgnoreCase(obj.getName())
                        && i.getUser().getId().equals(userId)
                        && !i.getId().equals(obj.getId()))
                .findFirst();
        if (inv.isPresent()) {
            throw new DataIntegratyViolationException("Inventário com esse nome já existe para o usuário");
        }
    }

}
