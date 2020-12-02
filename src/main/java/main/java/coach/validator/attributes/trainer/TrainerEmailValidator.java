package main.java.coach.validator.attributes.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;
import static main.java.coach.validator.ErrorValidator.*;
@Component
public class TrainerEmailValidator implements Validator<Trainer> {
    @Override
    public String validate(Trainer trainer) {
        String attribute = trainer.getEmail();
        if (attribute.isEmpty())
            return EMPTY_EMAIL_MESSAGE;
        else if(!attribute.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
            return INCORRECT_EMAIL_ADDRESS;
        return null;
    }
}
