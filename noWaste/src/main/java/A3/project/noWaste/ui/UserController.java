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
    public ResponseEntity listarUsuarios() {
        return ResponseEntity.ok().body(service.findAll());
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
