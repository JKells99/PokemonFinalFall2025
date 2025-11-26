package com.pokemon.trainer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public Trainer saveNewTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Iterable<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Optional<Trainer> findTrainerById(Long trainerId) {
       return trainerRepository.findById(trainerId);
    }

    public void deleteTrainerById(Long trainerId) {
        trainerRepository.deleteById(trainerId);
    }
}
