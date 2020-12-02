package main.java.coach.validator.attributes.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.validator.attributes.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PupilAttributesValidator {
    private final List<Validator<Pupil>> validators;

    @Autowired
    public PupilAttributesValidator(List<Validator<Pupil>> validators) {
        this.validators = validators;
    }


    public List<String> validate(Pupil pupil){
        return validators.stream()
                .map(e -> e.validate(pupil))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }



}
