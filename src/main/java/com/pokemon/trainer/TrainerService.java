package com.pokemon.trainer;


import com.pokemon.pokeball.PokeBall;
import com.pokemon.pokeball.PokeBallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PokeBallRepository pokeBallRepository;

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

    public Trainer addPokeBallsToTrainer(Long trainerId,String type, int numberOfBalls){
        Optional<Trainer> trainerOptional = trainerRepository.findById(trainerId);
        Optional<PokeBall> pokeBallOptional = pokeBallRepository.findPokeBallByType(type);
        List<PokeBall> pokeBalls = new ArrayList<>();
        // If trainer is present and poke ball is present, add poke ball to trainer's inventory and save the new type of ball
        // to the database if pokeball does exist we do not want to save a new one'

        if (trainerOptional.isPresent()) {
            Trainer trainer = trainerOptional.get();
            PokeBall pokeBall;
            if (pokeBallOptional.isPresent()) {
                pokeBall = pokeBallOptional.get();
                pokeBall.setQuantity(pokeBall.getQuantity() + numberOfBalls);
            } else {
                pokeBall = new PokeBall();
                pokeBall.setType(type);
                pokeBall.setQuantity(pokeBall.getQuantity());
                trainer.addPokeBallToInventory(pokeBall);
                pokeBallRepository.save(pokeBall);
            }

            return trainerRepository.save(trainer);
        } else {
            throw new RuntimeException("Trainer with ID " + trainerId + " not found");
        }

    }

}
