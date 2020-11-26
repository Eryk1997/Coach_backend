package main.java.coach.services.trainer.availability.checkers;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TrainerAvailabilityChecker {
    final private List<ITrainerAvailabilityChecker> checkers;
    final private TrainerRepository trainerRepository;

    public TrainerAvailabilityChecker(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
        checkers = new ArrayList<>();
        checkers.add(new TrainerEmailChecker());
    }

    public List<String> check(Trainer trainer){
        return checkers.stream()
                .map(e -> e.check(trainer, trainerRepository))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
