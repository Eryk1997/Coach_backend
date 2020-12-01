package main.java.coach.services.trainer.validator.checkers;

import main.java.coach.classes.trainer.Trainer;

public class TrainerNameValidator implements ITrainerAttributesValidator{
    @Override
    public String validate(Trainer trainer) {
        String attribute = trainer.getName();
        if (attribute.length() > 50){
            return "name is too long";
        }
        else if(attribute.length() < 3){
            return "name is too short";
        }else if(!attribute.matches("[A-Za-z0-9]+")){
            return "name contains illegal character";
        }
        return null;
    }
}
