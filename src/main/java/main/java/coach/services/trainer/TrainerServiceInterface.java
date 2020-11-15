package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;

import java.util.List;

public interface TrainerServiceInterface {
    List<Trainer> selectAllTrainers();
    Trainer getTrainer(Long id);
    void deleteTrainer(Long id);
    void addTrainer(Trainer trainer);
    void updateTrainer(Long id,Trainer trainer);

}
