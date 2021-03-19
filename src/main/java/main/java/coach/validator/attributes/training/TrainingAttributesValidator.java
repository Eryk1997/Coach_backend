package main.java.coach.validator.attributes.training;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.classes.training.Training;
import main.java.coach.validator.attributes.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TrainingAttributesValidator {
    private final List<Validator<Training>> validators;

    @Autowired
    public TrainingAttributesValidator(List<Validator<Training>> validators) {
        this.validators = validators;
    }

    public List<String> validate(Training training) {
        return validators.stream()
                .map(e -> e.validate(training))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
