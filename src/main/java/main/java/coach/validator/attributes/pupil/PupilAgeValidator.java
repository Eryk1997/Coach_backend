package main.java.coach.validator.attributes.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;

@Component
public class PupilAgeValidator implements Validator<Pupil> {
    @Override
    public String validate(Pupil pupil) {
        final int age = pupil.getAge();
        if (age == 0)
            return EMPTY_AGE_MESSAGE;
        else if(age < 0)
            return AGE_IS_TOO_SHORT;
        else if(age > 120)
            return AGE_IS_TOO_LONG;
        return null;
    }
}
