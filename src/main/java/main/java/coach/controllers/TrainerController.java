package main.java.coach.controllers;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.services.trainer.TrainerServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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


    @DeleteMapping("/trainer/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable Long id){
        trainerServiceInterface.deleteTrainer(id);
        return ResponseEntity.ok("Trainer is removed");
    }

    @PostMapping("/trainers")
    public ResponseEntity<String> addTrainer(@Valid @RequestBody Trainer trainer) {
        trainerServiceInterface.addTrainer(trainer);
        return ResponseEntity.ok("Trainer is added");
    }


    @PutMapping("/trainers/{id}")
    public ResponseEntity<String> updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer){
        trainerServiceInterface.updateTrainer(id,trainer);
        return ResponseEntity.ok("Trainer is updated");
    }

    @GetMapping("/trainer/{id}")
    public Trainer getTrainer(@PathVariable Long id){
        return trainerServiceInterface.getTrainer(id);
    }

}
