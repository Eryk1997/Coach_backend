package main.java.coach.validator.attributes.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;


@Component
public class PupilEmailValidator implements Validator<Pupil> {
    @Override
    public String validate(Pupil pupil) {
        String attribute = pupil.getEmail();
        if (attribute.isEmpty())
            return EMPTY_EMAIL_MESSAGE;
        else if(!attribute.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
            return INCORRECT_EMAIL_ADDRESS;

        return null;
    }
}
