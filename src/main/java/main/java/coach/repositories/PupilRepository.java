package main.java.coach.repositories;

import main.java.coach.classes.pupil.Pupil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PupilRepository extends CrudRepository<Pupil, Long> {
    Pupil findPupilById(Long id);
    Optional<Pupil> findPupilsByEmail(String email);
}
