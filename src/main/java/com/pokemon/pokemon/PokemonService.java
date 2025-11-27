package com.pokemon.pokemon;

import com.pokemon.trainer.Trainer;
import com.pokemon.trainer.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service layer containing business logic for Pokemon operations.
 *
 * This class delegates persistence to {@link PokemonRepository} and trainer
 * lookups to {@link TrainerRepository}.
 */
@Service
public class PokemonService {


    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TrainerRepository trainerRepository;

    /**
     * Persist a Pokemon.
     *
     * @param pokemon the Pokemon to save
     * @return the saved Pokemon (may include generated id)
     */
    public Pokemon savePokemon(Pokemon pokemon){
         return pokemonRepository.save(pokemon);
    }

    /**
     * Retrieve all Pokemon.
     *
     * @return iterable of all Pokemon
     */
    public Iterable<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    /**
     * Find a Pokemon by id.
     *
     * @param pokemonId id to look up
     * @return Optional containing the Pokemon if found
     */
    public Optional<Pokemon> getPokemonById(Long pokemonId) {
       return pokemonRepository.findById(pokemonId);
    }

    /**
     * Delete a Pokemon by id.
     *
     * @param pokemonId id to delete
     */
    public void deletePokemonById(Long pokemonId) {
        pokemonRepository.deleteById(pokemonId);
    }

    /**
     * Search Pokemon by exact name.
     *
     * @param name the name to look up
     * @return matching Pokemon
     */
    public Iterable<Pokemon> getPokemonByName(String name) {
        return pokemonRepository.findPokemonByName(name);
    }

    /**
     * Search Pokemon by type.
     *
     * @param type the type to look up
     * @return matching Pokemon
     */
    public Iterable<Pokemon> getPokemonByType(String type) {
        return pokemonRepository.findPokemonByType(type);
    }

    /**
     * Search Pokemon by hit points value.
     *
     * @param hitPoints hit point value to match
     * @return matching Pokemon
     */
    public Iterable<Pokemon> getPokemonByHitPoints(int hitPoints) {
        return pokemonRepository.findPokemonByHitPoints(hitPoints);
    }

    /**
     * Associate a trainer with a pokemon.
     *
     * If either the trainer or pokemon is missing this method currently
     * throws a RuntimeException.
     *
     * @param trainerId trainer id
     * @param pokemonId pokemon id
     */
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

    /**
     * Find Pokemon by their trainer's name.
     *
     * @param trainerName trainer's name
     * @return matching Pokemon
     */
    public Iterable<Pokemon> findPokemonByTrainerName(String trainerName) {
        return pokemonRepository.findPokemonByTrainer_Name(trainerName);
    }

    // TODO: Mess more with this method to make it more flexible
    /**
     * Search Pokemon using multiple optional parameters.
     *
     * Current behaviour: if exactly one parameter is provided it searches by
     * that parameter; if none or an unsupported combination is provided it
     * falls back to a repository method. This method may be extended for
     * more combinations in future.
     *
     * @param name optional name filter
     * @param type optional type filter
     * @param hitPoints optional hit points filter
     * @return matching Pokemon
     */
    public Iterable<Pokemon> searchPokemonByMultiParams(String name, String type, Integer hitPoints) {
        if(name != null){
            return pokemonRepository.findPokemonByName(name);
        } else if (type != null) {
            return pokemonRepository.findPokemonByType(type);
        } else if (hitPoints != null) {
            return pokemonRepository.findPokemonByHitPoints(hitPoints);
        } else {
            return pokemonRepository.findAllByHitPointsAndNameAndTrainer_Name(hitPoints, name, type);
        }

    }
}
