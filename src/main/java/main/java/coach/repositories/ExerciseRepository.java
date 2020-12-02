package main.java.coach.repositories;

import main.java.coach.classes.exercise.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    Optional<Exercise> findById(Long id);
}
