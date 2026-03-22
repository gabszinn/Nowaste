package A3.project.noWaste.ui;

import A3.project.noWaste.config.ModelMapperConfig;
import A3.project.noWaste.domain.User;
import A3.project.noWaste.domain.dto.UserDTO;
import A3.project.noWaste.service.exceptions.UserNotFoundException;
import A3.project.noWaste.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    private ModelMapper mapper;

    // BUSCAR UM USUÁRIO
    @GetMapping(value = "/{Id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer Id){
        return ResponseEntity.ok().body(mapper.map(service.findById(Id), UserDTO.class));
    }

    // LISTAR USUARIOS
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> mapper.map(x, UserDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    // CADASTRAR USUARIOS
    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid User user) {
        return ResponseEntity.status(201).body(service.create(user));
    }

    // DELETAR USUARIO
    @DeleteMapping("/{Id}")
    public ResponseEntity deletarUsuario(@PathVariable Integer Id) throws UserNotFoundException {
        boolean existe = service.delete(Id);
        if (!existe) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        return ResponseEntity.status(204).build();
    }
}
