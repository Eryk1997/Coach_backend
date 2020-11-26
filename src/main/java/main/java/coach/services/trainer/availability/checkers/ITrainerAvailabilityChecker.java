package main.java.coach.services.trainer.availability.checkers;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;

public interface ITrainerAvailabilityChecker {
    String check(Trainer trainer, TrainerRepository trainerRepository);
}
