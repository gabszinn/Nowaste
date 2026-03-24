package A3.project.noWaste.dto.requests;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Username é obrigatório") String username,
                                  @NotEmpty(message = "Email é obrigatório") String email,
                                  @NotEmpty(message = "Senha é obrigatória") String password) {
}
