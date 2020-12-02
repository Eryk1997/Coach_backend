package main.java.coach.validator.availability.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PupilAvailabilityValidator {
    private final List<AvailabilityValidator<Pupil>> validators;

    public PupilAvailabilityValidator(List<AvailabilityValidator<Pupil>> validators) {
        this.validators = validators;
    }

    public List<String> validate(Pupil pupil){
        return validators.stream()
                .map(e -> e.validate(pupil))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

