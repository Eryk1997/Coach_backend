package main.java.coach.repositories;

import main.java.coach.classes.trainer.Trainer;
import org.springframework.data.repository.CrudRepository;


public interface TrainerRepository extends CrudRepository<Trainer, Long> {
    Trainer findTrainerById(Long id);
}
