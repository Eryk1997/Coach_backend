package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface TrainerServiceInterface {
    List<Trainer> selectAllTrainers();
    UserDetails getTrainer(Long id);
    void deleteTrainer(Long id);
    List<String> addTrainer(Trainer trainer);
    List<String> updateTrainer(Long id,Trainer trainer);
    UserDetails getTrainer(String email);
}
