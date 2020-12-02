package main.java.coach.services.exercise;

import main.java.coach.classes.exercise.Exercise;

import java.util.List;

public interface ExerciseServiceInterface {
    List<Exercise> findAllExercises();
    Exercise findExerciseById(Long id);
}
