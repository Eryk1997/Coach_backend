package main.java.coach.controllers;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.services.trainer.TrainerServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainerController {

    private final TrainerServiceInterface trainerServiceInterface;


    public TrainerController(TrainerServiceInterface trainerServiceInterface) {
        this.trainerServiceInterface = trainerServiceInterface;
    }

    @GetMapping("/trainers")
    public List<Trainer> selectAllTrainers(){
       return trainerServiceInterface.selectAllTrainers();
    }



}
