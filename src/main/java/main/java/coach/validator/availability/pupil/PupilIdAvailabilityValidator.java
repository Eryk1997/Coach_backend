package main.java.coach.validator.availability.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.repositories.PupilRepository;
import main.java.coach.validator.availability.AvailabilityValidator;

import static main.java.coach.validator.ErrorValidator.*;
import java.util.Optional;

public class PupilIdAvailabilityValidator implements AvailabilityValidator<Pupil> {
    private final PupilRepository pupilRepository;

    public PupilIdAvailabilityValidator(PupilRepository pupilRepository) {
        this.pupilRepository = pupilRepository;
    }

    @Override
    public String validate(Pupil pupil) {
        Optional<Pupil> id = pupilRepository.findPupilById(pupil.getId());
        return id.map(e -> NOT_FOUND_PUPIL).orElse(null);
    }
}
