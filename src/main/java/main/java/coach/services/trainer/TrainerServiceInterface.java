package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;

import java.util.Collection;
import java.util.List;

public interface TrainerServiceInterface {
    List<Trainer> selectAllTrainers();
    /*
    public abstract void createTrainer(Trainer trainer);
    public abstract void updateTrainer(String id, Trainer trainer);
    public abstract void deleteTrainer(String id);
    public abstract Collection<Trainer> getTrainers();

     */
}
