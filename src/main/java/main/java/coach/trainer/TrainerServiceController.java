package main.java.coach.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainerServiceController {
    @Autowired
    TrainerServiceImplements trainerServiceImplements;

    @RequestMapping(value = "/trainers")
    public ResponseEntity<Object> getTrainers(){
        return new ResponseEntity<>(trainerServiceImplements.getTrainers(), HttpStatus.OK);
    }

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
}