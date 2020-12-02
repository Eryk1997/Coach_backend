package main.java.coach.repositories;

import main.java.coach.classes.trainer.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
    Optional<Trainer> findTrainerById(Long id);
    Optional<Trainer> findTrainerByEmail(String email);
}
