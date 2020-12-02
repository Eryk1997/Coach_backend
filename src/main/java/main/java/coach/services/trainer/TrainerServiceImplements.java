package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;
import main.java.coach.validator.attributes.trainer.TrainerAttributesValidator;
import main.java.coach.validator.availability.trainer.TrainerAvailabilityValidator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImplements implements TrainerServiceInterface {

    private final TrainerRepository trainerRepository;
    private final PasswordEncoder passwordEncoder;
    private final TrainerAttributesValidator trainerAttributesValidator;
    private final TrainerAvailabilityValidator trainerAvailabilityValidator;

    public TrainerServiceImplements(TrainerRepository trainerRepository, TrainerAttributesValidator trainerAttributesValidator, TrainerAvailabilityValidator trainerAvailabilityValidator) {
        this.trainerRepository = trainerRepository;
        this.trainerAttributesValidator = trainerAttributesValidator;
        this.trainerAvailabilityValidator = trainerAvailabilityValidator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<Trainer> selectAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        trainerRepository.findAll().forEach(trainers::add);
        return trainers;
    }

    @Override
    public UserDetails getTrainer(Long id) {
        Optional<Trainer> trainer = trainerRepository.findTrainerById(id);
        return trainer.orElseThrow(() -> new UsernameNotFoundException("Not found: " + id));
    }

    @Override
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override
    public List<String> addTrainer(Trainer trainer) {
        List<String> messages = trainerAttributesValidator.validate(trainer);
        messages.addAll(trainerAvailabilityValidator.validate(trainer));
        if (messages.isEmpty()) {
            trainerRepository.save(trainer
                    .toBuilder()
                    .name(trainer.getName())
                    .surname(trainer.getSurname())
                    .password(passwordEncoder.encode(trainer.getPassword()))
                    .email(trainer.getEmail())
                    .build());
        }
        return messages;
    }


    @Override
    public List<String> updateTrainer(Long id, Trainer trainer) {
        List<String> messages = trainerAttributesValidator.validate(trainer);
        if (messages.isEmpty()) {
            trainerRepository.save(trainerRepository.findTrainerById(id).orElse(null)
                    .toBuilder()
                    .name(trainer.getName())
                    .surname(trainer.getSurname())
                    .password(passwordEncoder.encode(trainer.getPassword()))
                    .email(trainer.getEmail())
                    .build());
            messages.add("update Trainer");
        }
        return messages;
    }

    @Override
    public UserDetails getTrainer(String email) throws UsernameNotFoundException {
        Optional<Trainer> trainer = trainerRepository.findTrainerByEmail(email);
        return trainer.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
    }


}