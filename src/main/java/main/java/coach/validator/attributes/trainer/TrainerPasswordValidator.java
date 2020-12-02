package main.java.coach.validator.attributes.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;
@Component
public class TrainerPasswordValidator implements Validator<Trainer> {
    @Override
    public String validate(Trainer trainer) {
        String attribute = trainer.getPassword();
        if (attribute.contains(" "))
            return EMPTY_PASSWORD_MESSAGE;
        else if (attribute.length() < 3)
            return PASSWORD_IS_TOO_SHORT;
        else if (attribute.length() > 100)
            return PASSWORD_IS_TOO_LONG;
        return null;
    }
}
