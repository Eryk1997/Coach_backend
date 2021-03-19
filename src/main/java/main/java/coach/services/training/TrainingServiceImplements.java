package main.java.coach.services.training;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.trainer.Trainer;
import main.java.coach.classes.training.Training;
import main.java.coach.repositories.PupilRepository;
import main.java.coach.repositories.TrainingRepository;
import main.java.coach.validator.attributes.training.TrainingAttributesValidator;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrainingServiceImplements implements TrainingServiceInterface {
    private final TrainingRepository trainingRepository;
    private final TrainingAttributesValidator trainingAttributesValidator;
    private final PupilRepository pupilRepository;


    public TrainingServiceImplements(TrainingRepository trainingRepository, TrainingAttributesValidator trainingAttributesValidator, PupilRepository pupilRepository) {
        this.trainingRepository = trainingRepository;
        this.trainingAttributesValidator = trainingAttributesValidator;
        this.pupilRepository = pupilRepository;
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
    public List<String> addTraining(Training training, Trainer trainer, Long id_pupil) {
        Pupil pupil = pupilRepository.findPupilById(id_pupil);
        if (trainer == null)
            return Collections.singletonList("you need log in to create training");
        List<String> message = trainingAttributesValidator.validate(training);
        if (message.isEmpty()) {
            trainingRepository.save(
                    training
                            .toBuilder()
                            .pupil(pupil)
                            .date(new Date())
                            .build());

        }

        return message;
    }

    @Override
    public List<Training> findTrainingsByIdPupil(Long id_pupil) {
        List<Training> trainings = new ArrayList<>();
        trainingRepository.findAllByPupil_Id(id_pupil).map(e -> trainings.add(e));


        return trainings;
    }

}
