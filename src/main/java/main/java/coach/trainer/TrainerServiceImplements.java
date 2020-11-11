package main.java.coach.trainer;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TrainerServiceImplements implements TrainerServiceInterface {
    private static Map<String, Trainer> trainerRepo = new HashMap<>();
    static {
        Trainer trainer = new Trainer("1","Eryk","Janocha","12345","test@o2.pl");
        trainerRepo.put(trainer.getId(),trainer);
        Trainer trainer1 = new Trainer("2","Alan","Duży","12345","poczta@interia.pl");
        trainerRepo.put(trainer1.getId(),trainer1);
    }

    @Override
    public void createTrainer(Trainer trainer) {
        trainerRepo.put(trainer.getId(),trainer);
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

    @Override
    public Collection<Trainer> getTrainers() {
        return trainerRepo.values();
    }
}
