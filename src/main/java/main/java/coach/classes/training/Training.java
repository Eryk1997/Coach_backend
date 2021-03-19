package main.java.coach.classes.training;

import lombok.*;
import main.java.coach.classes.exercise.Exercise;
import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.trainer.Trainer;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private Long id_exercise;

    @ManyToOne
    @JoinColumn(name = "id_pupil")
    private Pupil pupil;


    @Column(name = "date")
    private Date date;
    @Column(name = "weight")
    private int weight;
    @Column(name = "number_of_repetitions")
    private int number_of_repetitions;
}
