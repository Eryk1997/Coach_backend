package main.java.coach.validator.attributes.training;

import main.java.coach.classes.training.Training;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;

@Component
public class TrainingWeightValidator implements Validator<Training> {
    @Override
    public String validate(Training training) {
        final int weight = training.getWeight();
        if (weight == 0)
            return EMPTY_WEIGHT_MESSAGE;
        else if(weight < 0)
            return WEIGHT_IS_TOO_SHORT;
        else if (weight > 1000)
            return WEIGHT_IS_TOO_LONG;
        return null;
    }
}
