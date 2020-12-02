package main.java.coach.controllers;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.trainer.Trainer;
import main.java.coach.services.pupil.PupilServiceInterface;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PupilController {
    private final PupilServiceInterface pupilServiceInterface;

    public PupilController(PupilServiceInterface pupilServiceInterface) {
        this.pupilServiceInterface = pupilServiceInterface;
    }

    @GetMapping("/pupils")
    public List<Pupil> selectAllPupils(){
        return pupilServiceInterface.selectAllPupils();
    }

    @GetMapping("/pupil/{id}")
    public Pupil getPupil(@PathVariable Long id){
        return pupilServiceInterface.getPupil(id);
    }

    @PostMapping("/addPupil")
    public List<String> addPupil(@Valid @RequestBody Pupil pupil, @AuthenticationPrincipal Trainer trainer){
        return pupilServiceInterface.addPupil(pupil,trainer);
    }

    @GetMapping("/getPupilsByTrainerId/{id}")
    public List<Pupil> getPupilsByTrainerId(@PathVariable Long id){
        return pupilServiceInterface.getPupilsByTrainerId(id);
    }

    @DeleteMapping("/deletePupilById/{id}")
    public boolean deletePupilById(@PathVariable Long id,@AuthenticationPrincipal Trainer trainer){
        return pupilServiceInterface.deletePupilById(id,trainer);
    }

    @PutMapping("/updatePupil/{id}")
    public List<String> updatePupil(@PathVariable Long id,@RequestBody Pupil pupil){
        return pupilServiceInterface.updatePupil(id,pupil);
    }

}
