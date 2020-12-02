package main.java.coach.controllers;

import main.java.coach.classes.exercise.Exercise;
import main.java.coach.services.exercise.ExerciseServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseController {
    private final ExerciseServiceInterface exerciseServiceInterface;

    public ExerciseController(ExerciseServiceInterface exerciseServiceInterface) {
        this.exerciseServiceInterface = exerciseServiceInterface;
    }

    @GetMapping("/findAllExercises")
    public List<Exercise> findAllExercises() {
        return exerciseServiceInterface.findAllExercises();
    }

    @GetMapping("/findExerciseById/{id}")
    public Exercise findExerciseById(@PathVariable Long id) {
        return exerciseServiceInterface.findExerciseById(id);
    }
}
