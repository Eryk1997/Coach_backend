package main.java.coach.services.pupil;

import main.java.coach.classes.pupil.Pupil;
import main.java.coach.classes.trainer.Trainer;

import java.util.List;

public interface PupilServiceInterface {
    List<Pupil> selectAllPupils();
    Pupil getPupil(Long id);
    List<String> addPupil(Pupil pupil, Trainer trainer);
    List<Pupil> getPupilsByTrainerId(Long id);
    boolean deletePupilById(Long id,Trainer trainer);
    List<String> updatePupil(Long id_pupil, Pupil pupil);
}
