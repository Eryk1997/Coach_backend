package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer
                .toBuilder()
                .name(trainer.getName())
                .surname(trainer.getSurname())
                .password(passwordEncoder.encode(trainer.getPassword()))
                .email(trainer.getEmail())
                .build());
    }


    @Override
    public void updateTrainer(Long id, Trainer trainer) {
        trainerRepository.save(trainerRepository.findTrainerById(id)
                .toBuilder()
                .name(trainer.getName())
                .surname(trainer.getSurname())
                .password(passwordEncoder.encode(trainer.getPassword()))
                .email(trainer.getEmail())
                .build());
    }


}
