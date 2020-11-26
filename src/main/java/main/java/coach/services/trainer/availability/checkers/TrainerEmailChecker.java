package main.java.coach.services.trainer.availability.checkers;

import javassist.NotFoundException;
import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;

public class TrainerEmailChecker implements ITrainerAvailabilityChecker{
    @Override
    public String check(Trainer trainer, TrainerRepository trainerRepository) {
        try {
            trainerRepository.findTrainerByEmail(trainer.getEmail())
                    .orElseThrow(() -> new NotFoundException("Trainer not found"));
        }
        catch (NotFoundException ex){
            return null;
        }
        return "Trainer with given email already exists";
    }
}
