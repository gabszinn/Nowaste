package A3.project.noWaste.service.impl;

import A3.project.noWaste.domain.User;
import A3.project.noWaste.domain.dto.UserDTO;
import A3.project.noWaste.infra.UserRepository;
import A3.project.noWaste.service.UserService;
import A3.project.noWaste.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository repository;


    // find a user
    @Override
    public User findById(Integer Id) {
        Optional<User> obj = repository.findById(Id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    // find all Users
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    // create User
    @Override
    public User create(UserDTO obj) {
        User user = mapper.map(obj, User.class);
        return repository.save(user);
    }

    // delete User
    @Override
    public boolean delete(Integer id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
