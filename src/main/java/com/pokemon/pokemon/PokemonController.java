package com.pokemon.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//TODO: Return PROPER RESPONSES WITH RESPONSE ENTITY EVENTUALLY
/**
 * REST controller that exposes HTTP endpoints for managing Pokemon resources.
 *
 * Endpoints are rooted at /api/pokemon and currently provide basic CRUD
 * operations and a few search routes. Responses are intentionally simple;
 * controllers delegate business logic to {@link PokemonService}.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    /**
     * Create a new Pokemon.
     *
     * @param pokemon the Pokemon to create (deserialized from request body)
     * @return HTTP 201 with a brief success message
     */
    @PostMapping()
    public ResponseEntity<String> addPokemon(@RequestBody Pokemon pokemon){
        pokemonService.savePokemon(pokemon);
        String message = "Pokemon " + pokemon.getName() + " added successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    /**
     * Retrieve all Pokemon.
     *
     * @return an iterable of all Pokemon
     */
    @GetMapping
    public Iterable<Pokemon> getAllPokemon(){
        return pokemonService.getAllPokemon();
    }

    /**
     * Retrieve a single Pokemon by its id.
     *
     * @param pokemonId the id of the Pokemon to fetch
     * @return an Optional containing the Pokemon if found
     */
    @GetMapping("/{pokemonId}")
    public Optional<Pokemon> getPokemonById(@PathVariable Long pokemonId){
       return pokemonService.getPokemonById(pokemonId);
    }

    /**
     * Delete a Pokemon by id.
     *
     * @param pokemonId id of the Pokemon to delete
     * @return HTTP 200 with a brief success message
     */
    @DeleteMapping("/{pokemonId}")
    public ResponseEntity<String> deletePokemonById(@PathVariable Long pokemonId){
        pokemonService.deletePokemonById(pokemonId);
        String message = "Pokemon with ID " + pokemonId + " deleted successfully";
         return  new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Search Endpoints

    /**
     * Search Pokemon by exact name.
     *
     * @param name the name to search for (required)
     * @return matching Pokemon
     */
    @GetMapping("/searchByName")
    public Iterable<Pokemon> getPokemonByName(@RequestParam String name){
        return pokemonService.getPokemonByName(name);
    }

    /**
     * Search Pokemon by type.
     *
     * @param type the type to search for (optional)
     * @return matching Pokemon
     */
    @GetMapping("/searchByType")
    public Iterable<Pokemon> getPokemonByType(@RequestParam (required = false) String type){
        return pokemonService.getPokemonByType(type);
    }

    /**
     * Search Pokemon by hit points.
     *
     * @param hitPoints hit point value to search for
     * @return matching Pokemon
     */
    @GetMapping("/searchByHitPoints")
    public Iterable<Pokemon> getPokemonByHitPoints(@RequestParam int hitPoints){
        return  pokemonService.getPokemonByHitPoints(hitPoints);
    }
    /**
     * Associate an existing Pokemon with a Trainer.
     *
     * @param trainerId id of the trainer
     * @param pokemonId id of the pokemon
     * @return a short confirmation string (internal APIs should return ResponseEntity)
     */
    @PostMapping("/addTrainerToPokemon/{trainerId}/{pokemonId}")
    public String addTrainerToPokemon(@PathVariable Long trainerId, @PathVariable Long pokemonId){
        pokemonService.addTrainerToPokemon(trainerId, pokemonId);

        return "Pokemon added to trainer";
    }

    /**
     * Find Pokemon by their trainer's name.
     *
     * @param trainerName the trainer's name
     * @return Pokemon owned by trainers with that name
     */
    @GetMapping("/searchByTrainerName")
    public Iterable<Pokemon> findPokemonByTrainerName(@RequestParam String trainerName){
        return pokemonService.findPokemonByTrainerName(trainerName);
    }

    /**
     * Flexible search endpoint that delegates to the service. The service
     * currently supports searching by a single parameter or by all parameters.
     *
     * @param name optional name
     * @param type optional type
     * @param hitPoints optional hit points value
     * @return matching Pokemon wrapped in ResponseEntity with HTTP 200
     */
    @GetMapping("search")
    public ResponseEntity<Iterable<Pokemon>> searchPokemonWithMultipleParams(@RequestParam (required = false) String name,
                                                            @RequestParam (required = false )String type, @RequestParam (required = false )int hitPoints){
        return new ResponseEntity<>(pokemonService.searchPokemonByMultiParams(name, type, hitPoints), HttpStatus.OK);

    }
}
