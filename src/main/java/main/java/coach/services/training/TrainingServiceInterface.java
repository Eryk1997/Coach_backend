package main.java.coach.services.training;


import main.java.coach.classes.exercise.Exercise;
import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.trainer.Trainer;
import main.java.coach.classes.training.Training;

import java.util.Date;
import java.util.List;

public interface TrainingServiceInterface {
    List<Training> findAllTrainings();
    void deleteTraining(Long id);
    List<String> addTraining(Training training, Trainer trainer, Long id_pupil);
    List<Training> findTrainingsByIdPupil(Long id_pupil);
}
