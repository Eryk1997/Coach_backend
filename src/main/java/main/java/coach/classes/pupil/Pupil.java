package main.java.coach.classes.pupil;

import lombok.*;
import main.java.coach.classes.training.Training;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private int growth;
    private int weight;
    private int age;
    private Long id_trainer;
    private String email;
}
