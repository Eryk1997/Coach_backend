package main.java.coach.repositories;

import main.java.coach.classes.training.Training;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {
    Optional<Training> findById(Long id);
    Optional<Training> findAllByPupil_Id(Long id_pupil);
}
