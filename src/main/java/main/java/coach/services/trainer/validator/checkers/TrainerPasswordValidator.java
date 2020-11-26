package main.java.coach.services.trainer.validator.checkers;

import main.java.coach.classes.trainer.Trainer;

public class TrainerPasswordValidator implements ITrainerAttributesValidator {
    @Override
    public String validate(Trainer trainer) {
        String attribute = trainer.getPassword();
        if(attribute.length() > 71){
            return "password is too long";
        } else if(attribute.length() < 3) {
            return "password is too short";
        } else if(attribute.contains(" ")){
            return "password contains illegal character";
        }
        return null;
    }
}
