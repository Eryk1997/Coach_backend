package main.java.coach.validator.attributes.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;

@Component
public class TrainerSurnameValidator implements Validator<Trainer> {
    @Override
    public String validate(Trainer trainer) {
        String attribute = trainer.getSurname();
        if (attribute.isEmpty())
            return EMPTY_SURNAME_MESSAGE;
        else if(attribute.length() < 3)
            return SURNAME_IS_TOO_SHORT;
        else if(attribute.length() > 50)
            return SURNAME_IS_TOO_LONG;
        else if (!attribute.matches("[A-Za-z0-9]+"))
            return SURNAME_CONTAINS_ILLEGAL_CHARACTER;

        return null;
    }
}
