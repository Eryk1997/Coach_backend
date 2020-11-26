package main.java.coach.services.trainer.validator.checkers;

import main.java.coach.classes.trainer.Trainer;

public class TrainerEmailValidator implements ITrainerAttributesValidator {

    @Override
    public String validate(Trainer trainer) {
        String attribute = trainer.getEmail();
        if(!attribute.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            return "incorrect email address";
        }
        return null;
    }
}
