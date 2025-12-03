package com.pokemon.trainer;

import com.pokemon.pokeball.PokeBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @Autowired
    PokeBallService pokeBallService;

    @PostMapping()
    public Trainer saveNewTrainerToDb(@RequestBody Trainer trainer) {
        return trainerService.saveNewTrainer(trainer);
    }

    @GetMapping("/getAllTrainers")
    public Iterable<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{trainerId}")
    public Optional<Trainer> findByTrainerId(@PathVariable Long trainerId) {
        return trainerService.findTrainerById(trainerId);
    }

    @DeleteMapping("/{trainerId}")
    public String deleteTrainerById(@PathVariable Long trainerId) {
        trainerService.deleteTrainerById(trainerId);
        return "Trainer with ID " + trainerId + " deleted successfully";
    }

    @PostMapping("/addPokeBallsToInventory/{trainerId}/{type}/{numberOfBalls}")
    public ResponseEntity<Trainer> addPokeBallsToInventory(@PathVariable Long trainerId, @PathVariable String type, @PathVariable int numberOfBalls) {
         return new ResponseEntity<>( trainerService.addPokeBallsToTrainer(trainerId,type,numberOfBalls), HttpStatus.CREATED);
    }
}
