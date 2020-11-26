package main.java.coach.services.trainer.validator;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.services.trainer.validator.checkers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddTrainerValidator {
    final private List<ITrainerAttributesValidator> validators;

    public AddTrainerValidator(){
        validators = new ArrayList<>();
        validators.add(new TrainerNameValidator());
        validators.add(new TrainerSurnameValidator());
        validators.add(new TrainerEmailValidator());
        validators.add(new TrainerPasswordValidator());
    }

    public List<String> validate(Trainer trainer){
        return validators
                .stream()
                .map(e -> e.validate(trainer))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
