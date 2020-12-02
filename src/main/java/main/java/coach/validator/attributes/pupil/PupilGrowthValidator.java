package main.java.coach.validator.attributes.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;

@Component
public class PupilGrowthValidator implements Validator<Pupil> {
    @Override
    public String validate(Pupil pupil) {
        final int growth = pupil.getGrowth();
        if (growth == 0)
            return EMPTY_GROWTH_MESSAGE;
        else if (growth < 0)
            return GROWTH_IS_TOO_SHORT;
        else if (growth > 300)
            return GROWTH_IS_TOO_LONG;
        return null;

    }
}
