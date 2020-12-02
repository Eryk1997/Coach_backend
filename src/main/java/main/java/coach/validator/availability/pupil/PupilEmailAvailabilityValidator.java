package main.java.coach.validator.availability.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.repositories.PupilRepository;
import main.java.coach.validator.availability.AvailabilityValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static main.java.coach.validator.ErrorValidator.NOT_AVAILABLE_EMAIL_MESSAGE;

@Component
public class PupilEmailAvailabilityValidator implements AvailabilityValidator<Pupil> {
    private final PupilRepository pupilRepository;

    public PupilEmailAvailabilityValidator(PupilRepository pupilRepository) {
        this.pupilRepository = pupilRepository;
    }

    @Override
    public String validate(Pupil pupil) {
        Optional<Pupil> email = pupilRepository.findPupilsByEmail(pupil.getEmail());
        return email.map(e -> NOT_AVAILABLE_EMAIL_MESSAGE).orElse(null);
    }
}
