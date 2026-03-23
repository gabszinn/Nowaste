package A3.project.noWaste.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotBlank(message = "Nome não pode ser nulo")
    private String Username;

    @Column(unique = true)
    @Email(message = "Email digitado inválido")
    private String email;

    @NotBlank(message = "Senha não pode ser nula")
    private String password;

}
