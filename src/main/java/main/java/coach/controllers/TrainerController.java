package main.java.coach.controllers;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.services.trainer.TrainerServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TrainerController {

    private final TrainerServiceInterface trainerServiceInterface;

    public TrainerController(TrainerServiceInterface trainerServiceInterface) {
        this.trainerServiceInterface = trainerServiceInterface;
    }

    @GetMapping("/trainers")
    public List<Trainer> selectAllTrainers() {
        return trainerServiceInterface.selectAllTrainers();
    }

    @GetMapping("/trainer/{id}")
    public Trainer getTrainer(@PathVariable Long id) {
        return trainerServiceInterface.getTrainer(id);
    }

    @DeleteMapping("/trainer/{id}")
    public void deleteTrainer(@PathVariable Long id){
        trainerServiceInterface.deleteTrainer(id);
    }

    @PostMapping("/trainers")
    public void addTrainer(@RequestBody Trainer trainer) {
        trainerServiceInterface.addTrainer(trainer);
    }

    @PutMapping("/trainers/{id}")
    public void updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer){
        trainerServiceInterface.updateTrainer(id,trainer);
    }



}
