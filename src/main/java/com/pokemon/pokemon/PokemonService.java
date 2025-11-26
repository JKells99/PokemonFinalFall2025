package com.pokemon.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

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
}
