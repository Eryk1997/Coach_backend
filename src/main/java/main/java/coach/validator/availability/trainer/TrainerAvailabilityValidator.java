package main.java.coach.validator.availability.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TrainerAvailabilityValidator {
    private final List<AvailabilityValidator<Trainer>> validators;

    public TrainerAvailabilityValidator(List<AvailabilityValidator<Trainer>> validators) {
        this.validators = validators;
    }

    public List<String> validate(Trainer trainer){
        return validators.stream()
                .map(e -> e.validate(trainer))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
