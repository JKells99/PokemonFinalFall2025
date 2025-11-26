package com.pokemon.pokemon;

import com.pokemon.trainer.Trainer;
import com.pokemon.trainer.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TrainerRepository trainerRepository;

    public Pokemon savePokemon(Pokemon pokemon){
         return pokemonRepository.save(pokemon);
    }

    public Iterable<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long pokemonId) {
       return pokemonRepository.findById(pokemonId);
    }

    public void deletePokemonById(Long pokemonId) {
        pokemonRepository.deleteById(pokemonId);
    }

    public Iterable<Pokemon> getPokemonByName(String name) {
        return pokemonRepository.findPokemonByName(name);
    }

    public Iterable<Pokemon> getPokemonByType(String type) {
        return pokemonRepository.findPokemonByType(type);
    }

    public Iterable<Pokemon> getPokemonByHitPoints(int hitPoints) {
        return pokemonRepository.findPokemonByHitPoints(hitPoints);
    }

    public void addTrainerToPokemon(Long trainerId, Long pokemonId) {
        Optional<Trainer> trainerOpt = trainerRepository.findById(trainerId);
        Optional<Pokemon> pokemonOpt = pokemonRepository.findById(pokemonId);

        try {
            if(trainerOpt.isPresent() && pokemonOpt.isPresent()){
                Pokemon pokemon = pokemonOpt.get();
                Trainer trainer = trainerOpt.get();
                pokemon.setTrainer(trainer);
                pokemonRepository.save(pokemon);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException("Trainer or Pokemon not found");
        }


    }

    public Iterable<Pokemon> findPokemonByTrainerName(String trainerName) {
        return pokemonRepository.findPokemonByTrainer_Name(trainerName);
    }
}
