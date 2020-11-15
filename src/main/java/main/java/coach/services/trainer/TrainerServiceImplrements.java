package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerServiceImplrements implements TrainerServiceInterface {

    private final TrainerRepository trainerRepository;

    public TrainerServiceImplrements(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
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
        trainerRepository.save(trainer);
    }


    @Override
    public void updateTrainer(Long id, Trainer trainer) {
        Trainer trainerToUpdate = trainerRepository.findTrainerById(id);
       /* trainerToUpdate.toBuilder()
                .name(trainer.getName())
                .email(trainer.getEmail())
                .password(trainer.getPassword())
                .surname(trainer.getSurname())
                .build();

        */
        trainerToUpdate.setName(trainer.getName());
        trainerToUpdate.setSurname(trainer.getSurname());
        trainerToUpdate.setPassword(trainer.getPassword());
        trainerToUpdate.setEmail(trainer.getEmail());
        trainerRepository.save(trainerToUpdate);


    }


}
