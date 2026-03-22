package A3.project.noWaste.service.impl;

import A3.project.noWaste.domain.User;
import A3.project.noWaste.infra.UserRepository;
import A3.project.noWaste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    // find a user
    @Override
    public User findById(Integer Id) {
        Optional<User> obj = repository.findById(Id);
        return obj.orElse(null);
    }

    // find all Users
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    // create User
    @Override
    public User create(User user) {
        if (!repository.existsByEmail(user.getEmail())) {
            String encoder = passwordEncoder.encode(user.getPassword());
            user.setPassword(encoder);
            User newUser = repository.save(user);
            return newUser;
        } else {
            throw new RuntimeException("email inserido já cadastrado");
        }
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
