package main.java.coach.controllers;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.services.trainer.TrainerServiceImplements;
import main.java.coach.services.trainer.TrainerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@RestController
public class TrainerServiceController {

    private final TrainerServiceInterface trainerServiceInterface;

    public TrainerServiceController(TrainerServiceInterface trainerServiceInterface) {
        this.trainerServiceInterface = trainerServiceInterface;
    }

    @GetMapping("/trainers")
    public String selectAllTrainers(Model model){
        List<Trainer> trainer = trainerServiceInterface.selectAllTrainers();
        model.addAttribute("trainer", trainer);
        return "trainers";
    }

    /*
    @Autowired
    TrainerServiceImplements trainerServiceImplements;

    @RequestMapping(value = "/trainers")
    public List<Trainer> getTrainers(){
        return trainerServiceImplements.getAllTrainers();
    }

     */


/*
    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTrainer(@PathVariable("id") String id, @RequestBody Trainer trainer){
        trainerServiceImplements.updateTrainer(id, trainer);
        return new ResponseEntity<>("Trainer is updated successfully",HttpStatus.OK);
    }


    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTrainer(@PathVariable("id") String id){
        trainerServiceImplements.deleteTrainer(id);
        return new ResponseEntity<>("Trainer is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/trainers", method = RequestMethod.POST)
    public ResponseEntity<Object> createTrainer(@RequestBody Trainer trainer){
        trainerServiceImplements.createTrainer(trainer);
        return new ResponseEntity<>("Trainer is created successfully", HttpStatus.OK);
    }
*/
}