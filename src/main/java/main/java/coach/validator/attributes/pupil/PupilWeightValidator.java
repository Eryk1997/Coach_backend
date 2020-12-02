package main.java.coach.validator.attributes.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;


@Component
public class PupilWeightValidator implements Validator<Pupil> {
    @Override
    public String validate(Pupil pupil) {
        final int weight = pupil.getWeight();
        if (weight == 0)
            return EMPTY_WEIGHT_MESSAGE;
        else if(weight < 0)
            return WEIGHT_IS_TOO_SHORT;
        else if(weight > 300)
            return WEIGHT_IS_TOO_LONG;
        return null;
    }
}
