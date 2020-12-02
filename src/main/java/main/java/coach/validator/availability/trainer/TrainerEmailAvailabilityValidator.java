package main.java.coach.validator.availability.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;
import main.java.coach.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;
import static main.java.coach.validator.ErrorValidator.*;

import java.util.Optional;

@Component
public class TrainerEmailAvailabilityValidator implements AvailabilityValidator<Trainer> {
    private final TrainerRepository trainerRepository;

    public TrainerEmailAvailabilityValidator(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public String validate(Trainer trainer) {
        Optional<Trainer> email = trainerRepository.findTrainerByEmail(trainer.getEmail());
        return email.map(e -> NOT_AVAILABLE_EMAIL_MESSAGE).orElse(null);
    }
}
