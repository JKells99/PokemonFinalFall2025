package com.pokemon.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @PostMapping()
    public ResponseEntity<String> addPokemon(@RequestBody Pokemon pokemon){
        pokemonService.savePokemon(pokemon);
        String message = "Pokemon " + pokemon.getName() + " added successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<Pokemon> getAllPokemon(){
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/{pokemonId}")
    public Optional<Pokemon> getPokemonById(@PathVariable Long pokemonId){
       return pokemonService.getPokemonById(pokemonId);
    }

    @DeleteMapping("/{pokemonId}")
    public ResponseEntity<String> deletePokemonById(@PathVariable Long pokemonId){
        pokemonService.deletePokemonById(pokemonId);
        String message = "Pokemon with ID " + pokemonId + " deleted successfully";
         return  new ResponseEntity<String>(message, HttpStatus.OK);
    }

    // Search Endpoints

    @GetMapping("/searchByName")
    public Iterable<Pokemon> getPokemonByName(@RequestParam String name){
        return pokemonService.getPokemonByName(name);
    }

    @GetMapping("/searchByType")
    public Iterable<Pokemon> getPokemonByType(@RequestParam (required = false) String type){
        return pokemonService.getPokemonByType(type);
    }

    @GetMapping("/searchByHitPoints")
    public Iterable<Pokemon> getPokemonByHitPoints(@RequestParam int hitPoints){
        return  pokemonService.getPokemonByHitPoints(hitPoints);
    }

//    @PutMapping("/{pokemonId}")
//    public ResponseEntity<String> updatePokemon(@PathVariable Long pokemonId, @RequestBody Pokemon updatedPokemon){
//        Optional<Pokemon> existingPokemonOpt = pokemonService.getPokemonById(pokemonId);
//        if(existingPokemonOpt.isPresent()){
//            Pokemon existingPokemon = existingPokemonOpt.get();
//            existingPokemon.setName(updatedPokemon.getName());
//            existingPokemon.setType(updatedPokemon.getType());
//            existingPokemon.setHitPoints(updatedPokemon.getHitPoints());
//            pokemonService.savePokemon(existingPokemon);
//            String message = "Pokemon with ID " + pokemonId + " updated successfully";
//            return new ResponseEntity<>(message, HttpStatus.OK);
//        } else {
//            String message = "Pokemon with ID " + pokemonId + " not found";
//            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
//        }
//    }
}

