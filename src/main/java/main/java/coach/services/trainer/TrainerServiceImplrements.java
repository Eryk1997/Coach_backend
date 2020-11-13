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
}
