package main.java.coach.validator.attributes.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.validator.attributes.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TrainerAttributesValidator {
    private final List<Validator<Trainer>> validators;

    @Autowired
    public TrainerAttributesValidator(List<Validator<Trainer>> validators) {
        this.validators = validators;
    }

    public List<String> validate(Trainer trainer) {
        return validators.stream()
                .map(e -> e.validate(trainer))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
