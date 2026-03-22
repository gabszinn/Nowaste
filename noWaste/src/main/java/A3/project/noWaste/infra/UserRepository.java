package A3.project.noWaste.infra;

import A3.project.noWaste.domain.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(@Email(message = "Email digitado inválido") String email);
}
