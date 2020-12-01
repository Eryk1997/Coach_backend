package main.java.coach.services.trainer.validator.checkers;

import main.java.coach.classes.trainer.Trainer;

public class TrainerSurnameValidator implements ITrainerAttributesValidator {
    @Override
    public String validate(Trainer trainer) {
        String attribute = trainer.getSurname();
        if(attribute.length() > 50){
            return "surname is too long";
        } else if(attribute.length() < 3) {
            return "surname is too short";
        } else if(!attribute.matches("[a-zA-Z]+")){
            return "surname contains illegal character";
        }
        return null;
    }
}
