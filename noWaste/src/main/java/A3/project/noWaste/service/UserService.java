package A3.project.noWaste.service;

import A3.project.noWaste.domain.User;
import A3.project.noWaste.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(Integer Id);

    List<User> findAll();

    User create(UserDTO obj);

    boolean delete(Integer id);

}
