package main.java.coach.validator.attributes.training;

import main.java.coach.classes.training.Training;
import main.java.coach.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.java.coach.validator.ErrorValidator.*;

@Component
public class TrainingNumberOfRepetitionsValidator implements Validator<Training> {
    @Override
    public String validate(Training training) {
        final int number_of_repetitions = training.getNumber_of_repetitions();
        if (number_of_repetitions == 0)
            return EMPTY_NUMBER_OF_REPETITIONS_MESSAGE;
        else if(number_of_repetitions < 0)
            return EMPTY_NUMBER_OF_REPETITIONS_IS_TOO_SHORT;
        else if (number_of_repetitions > 1000)
            return EMPTY_NUMBER_OF_REPETITIONS_IS_TOO_LONG;
        return null;
    }
}
