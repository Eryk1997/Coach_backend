package main.java.coach.controllers;

import main.java.coach.classes.exercise.Exercise;
import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.trainer.Trainer;
import main.java.coach.classes.training.Training;
import main.java.coach.services.training.TrainingServiceInterface;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TrainingController {
    private final TrainingServiceInterface trainingServiceInterface;

    public TrainingController(TrainingServiceInterface trainingServiceInterface) {
        this.trainingServiceInterface = trainingServiceInterface;
    }

    @GetMapping("/getAllTraining")
    public List<Training> findAllTrainings() {
        return trainingServiceInterface.findAllTrainings();
    }

    @DeleteMapping("/deleteTrainingById/{id}")
    public void deleteTraining(@PathVariable Long id) {
        trainingServiceInterface.deleteTraining(id);
    }

    @PostMapping("/addTraining")
    public List<String> addTraining(@Valid @RequestBody Training training, @AuthenticationPrincipal Trainer trainer){
        return trainingServiceInterface.addTraining(training,trainer);
    }

}
