package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;

import java.util.List;

public interface TrainerServiceInterface {
    List<Trainer> selectAllTrainers();
}
