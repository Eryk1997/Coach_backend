package main.java.coach.services.exercise;

import main.java.coach.classes.exercise.Exercise;
import main.java.coach.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImplements implements ExerciseServiceInterface {
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImplements(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercise> findAllExercises() {
        List<Exercise> exercises = new ArrayList<>();
        exerciseRepository.findAll().forEach(exercises::add);
        return exercises;
    }

    @Override
    public Exercise findExerciseById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }
}
