package A3.project.noWaste.config;

import A3.project.noWaste.domain.User;
import A3.project.noWaste.infra.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Henrique", "henrique@email.com", "1234");
        repository.save(u1);
    }
}
