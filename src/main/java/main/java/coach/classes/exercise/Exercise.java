package main.java.coach.classes.exercise;

import lombok.*;
import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.training.Training;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;


}
