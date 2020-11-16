package main.java.coach.classes.trainer;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank(message = "surname is mandatory")
    @Size(min = 1, max = 50)
    private String surname;

    @NotBlank(message = "password is mandatory")
    @Size(min = 1, max = 100)
    private String password;

    @NotBlank(message = "email is mandatory")
    @Size(min = 1, max = 50)
    @Email
    private String email;


}
