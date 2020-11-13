package main.java.coach.services.trainer;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

//@Repository("postgres")
@Service
public class TrainerServiceImplements implements TrainerServiceInterface{

    private final TrainerRepository trainerRepository;

    public TrainerServiceImplements(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<Trainer> selectAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        trainerRepository.findAll()
                .forEach(trainers::add);
        return trainers;
    }

    /*
    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImplements(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers(){
        return trainerRepository.selectAllTrainers();
    }

     */
/*
    @Override
    public void createTrainer(Trainer trainer) {

    }

    @Override
    public void updateTrainer(String id, Trainer trainer) {

    }

    @Override
    public void deleteTrainer(String id) {

    }
*/
    /*
        static {
            Trainer trainer = new Trainer("1", "Eryk", "Janocha", "12345", "test@o2.pl");
            trainerRepo.put(trainer.getId(), trainer);
            Trainer trainer1 = new Trainer("2", "Alan", "Duży", "12345", "poczta@interia.pl");
            trainerRepo.put(trainer1.getId(), trainer1);
        }
    */
/*
    @Override
    public void createTrainer(Trainer trainer) {
        trainerRepo.put(trainer.getId(), trainer);
    }

    @Override
    public void updateTrainer(String id, Trainer trainer) {
        trainerRepo.remove(id);
        trainer.setId(id);
        trainerRepo.put(id, trainer);
    }

    @Override
    public void deleteTrainer(String id) {
        trainerRepo.remove(id);
    }
*/


}
