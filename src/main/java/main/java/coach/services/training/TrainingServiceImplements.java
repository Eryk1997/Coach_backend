package main.java.coach.services.training;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.classes.training.Training;
import main.java.coach.repositories.TrainingRepository;
import main.java.coach.validator.attributes.training.TrainingAttributesValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TrainingServiceImplements implements TrainingServiceInterface {
    private final TrainingRepository trainingRepository;
    private final TrainingAttributesValidator trainingAttributesValidator;


    public TrainingServiceImplements(TrainingRepository trainingRepository, TrainingAttributesValidator trainingAttributesValidator) {
        this.trainingRepository = trainingRepository;
        this.trainingAttributesValidator = trainingAttributesValidator;
    }


    @Override
    public List<Training> findAllTrainings() {
        List<Training> trainings = new ArrayList<>();
        trainingRepository.findAll().forEach(trainings::add);
        return trainings;
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }


    @Override
    public List<String> addTraining(Training training, Trainer trainer) {
        if (trainer == null)
            return Collections.singletonList("you need log in to create training");
        List<String> message = trainingAttributesValidator.validate(training);
        if (message.isEmpty()) {
            trainingRepository.save(
                    training
                            .toBuilder()
                            .date(new Date())
                            .build());

        }

        return message;
    }

}
