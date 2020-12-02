package main.java.coach.configuration;

import main.java.coach.classes.trainer.Trainer;
import main.java.coach.repositories.TrainerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final TrainerRepository trainerRepository;

    public UserDetailsServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Trainer> trainer = trainerRepository.findTrainerByEmail(email);
        return trainer.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
    }
}
