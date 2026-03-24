package A3.project.noWaste.service;

import A3.project.noWaste.config.TokenConfig;
import A3.project.noWaste.domain.User;
import A3.project.noWaste.exceptions.ObjectNotFoundException;
import A3.project.noWaste.infra.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@Service
public class VerificationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenConfig tokenConfig;


    // Pegar token do cabeçalho Authorization
    public String processarComAuthorization() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        } else {
            throw new RuntimeException("Valor do cabeçalho é nulo");
        }
    }

    // Pegar id do usuario logado
    public Integer pegarIdUsuario() {
        var subject = tokenConfig.getSubject(processarComAuthorization());
        Optional<User> user = userRepository.findByEmail(subject);
        if (user.isPresent()) {
            var  userId = user.get().getId();
            return userId;
        } else {
            throw new ObjectNotFoundException("Valor do userId é nulo");
        }
    }

    // verificar usuario
    public User verifyUser() {
        Integer userId = pegarIdUsuario();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
        return user;
    }
}
