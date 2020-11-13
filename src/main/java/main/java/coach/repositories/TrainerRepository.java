package main.java.coach.repositories;

import main.java.coach.classes.trainer.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TrainerRepository extends CrudRepository<Trainer, UUID> {
}
