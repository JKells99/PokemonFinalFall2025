package com.pokemon.trainer;

import com.pokemon.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping()
    public Trainer saveNewTrainerToDb(@RequestBody Trainer trainer){
        return trainerService.saveNewTrainer(trainer);
    }

    @GetMapping("/getAllTrainers")
    public Iterable<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{trainerId}")
    public Optional<Trainer> findByTrainerId(@PathVariable Long trainerId){
         return trainerService.findTrainerById(trainerId);
    }

    @DeleteMapping("/{trainerId}")
    public String deleteTrainerById(@PathVariable Long trainerId){
        trainerService.deleteTrainerById(trainerId);
        return "Trainer with ID " + trainerId + " deleted successfully";
    }


}
