package main.java.coach.trainer;

import java.util.Collection;

public interface TrainerServiceInterface {
    public abstract void createTrainer(Trainer trainer);
    public abstract void updateTrainer(String id, Trainer trainer);
    public abstract void deleteTrainer(String id);
    public abstract Collection<Trainer> getTrainers();
}
