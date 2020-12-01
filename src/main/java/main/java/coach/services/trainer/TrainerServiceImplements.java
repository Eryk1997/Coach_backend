package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;
import main.java.coach.services.trainer.availability.checkers.TrainerAvailabilityChecker;
import main.java.coach.services.trainer.validator.AddTrainerValidator;
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

    public TrainerServiceImplements(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<Trainer> selectAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        trainerRepository.findAll().forEach(trainers::add);
        return trainers;
    }

    @Override
    public Trainer getTrainer(Long id) {
        Trainer trainer = trainerRepository.findTrainerById(id);
        return trainer;
    }

    @Override
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override
    public List<String> addTrainer(Trainer trainer) {
        AddTrainerValidator validator = new AddTrainerValidator();
        TrainerAvailabilityChecker checker = new TrainerAvailabilityChecker(trainerRepository);
        List<String> messages = validator.validate(trainer);
        messages.addAll(checker.check(trainer));
        if (messages.isEmpty()){
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
        AddTrainerValidator validator = new AddTrainerValidator();
        List<String> messages = validator.validate(trainer);
        if (messages.isEmpty()) {
            trainerRepository.save(trainerRepository.findTrainerById(id)
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
    public UserDetails getTrainer(String email) throws UsernameNotFoundException  {
        Optional<Trainer> trainer = trainerRepository.findTrainerByEmail(email);
        return trainer.orElseThrow(()-> new UsernameNotFoundException("Not found: " + email));
    }


}