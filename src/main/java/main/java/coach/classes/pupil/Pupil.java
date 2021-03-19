package main.java.coach.classes.pupil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import main.java.coach.classes.trainer.Trainer;
import main.java.coach.classes.training.Training;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "pupil")
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
    @Column(name = "growth")
    private int growth;
    @Column(name = "weight")
    private int weight;
    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_trainer", nullable = false)
    private Trainer trainer;


    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "pupil")
    private Set<Training> trainings;


}
