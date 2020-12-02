package main.java.coach.services.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.PupilRepository;
import main.java.coach.validator.attributes.pupil.PupilAttributesValidator;
import main.java.coach.validator.availability.pupil.PupilAvailabilityValidator;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static main.java.coach.validator.ErrorValidator.NOT_FOUND_PUPIL;

@Service
public class PupilServiceImplements implements PupilServiceInterface {

    private final PupilRepository pupilRepository;
    private final PupilAttributesValidator pupilAttributesValidator;
    private final PupilAvailabilityValidator pupilAvailabilityValidator;

    @PersistenceContext
    private EntityManager entityManager;

    public PupilServiceImplements(PupilRepository pupilRepository, PupilAttributesValidator pupilAttributesValidator, PupilAvailabilityValidator pupilAvailabilityValidator) {
        this.pupilRepository = pupilRepository;
        this.pupilAttributesValidator = pupilAttributesValidator;
        this.pupilAvailabilityValidator = pupilAvailabilityValidator;
    }

    @Override
    public List<Pupil> selectAllPupils() {
        List<Pupil> pupils = new ArrayList<>();
        pupilRepository.findAll().forEach(pupils::add);
        return pupils;
    }

    @Override
    public Pupil getPupil(Long id) {
        Optional<Pupil> pupil = pupilRepository.findPupilById(id);
        return pupil.orElseThrow(() -> new UsernameNotFoundException(NOT_FOUND_PUPIL));
    }

    @Override
    public List<String> addPupil(Pupil pupil, Trainer trainer) {
        if (trainer == null)
            return Collections.singletonList("you need log in to create pupil");
        List<String> message = pupilAttributesValidator.validate(pupil);
        message.addAll(pupilAvailabilityValidator.validate(pupil));
        if (message.isEmpty()) {
            pupilRepository.save(pupil
                    .toBuilder()
                    .id_trainer(trainer.getId())
                    .build()
            );
        }
        return message;
    }

    @Override
    public List<Pupil> getPupilsByTrainerId(Long id) {
        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pupil> query = cb.createQuery(Pupil.class);
        Root<Pupil> table = query.from(Pupil.class);
        if (id != null)
            predicates.add(cb.equal(table.get("id_trainer"), id));
        query.where(cb.and(predicates.toArray(new Predicate[0])));
        final TypedQuery<Pupil> result = entityManager.createQuery(query);
        return result.getResultList();
    }

    @Override
    public boolean deletePupilById(Long id_pupil, Trainer trainer) {
        if (trainer == null)
            return false;
        pupilRepository.findPupilById(id_pupil).orElse(null);
        pupilRepository.deleteById(id_pupil);
        return true;
    }

    @Override
    public List<String> updatePupil(Long id_pupil, Pupil pupil) {
        List<String> messgage = pupilAttributesValidator.validate(pupil);
        if (messgage.isEmpty()){
            pupilRepository.save(pupilRepository.findPupilById(id_pupil).orElse(null)
                    .toBuilder()
                    .name(pupil.getName())
                    .surname(pupil.getSurname())
                    .age(pupil.getAge())
                    .growth(pupil.getGrowth())
                    .weight(pupil.getWeight())
                    .email(pupil.getEmail())
                    .build());
            messgage.add("Update pupil");
        }
        return messgage;
    }


}
