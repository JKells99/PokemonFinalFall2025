package com.pokemon.dto;

public class TrainerPokemonDTO {
    private String trainerName;
    private String pokemonName;

    public TrainerPokemonDTO(String trainerName, String pokemonName) {
        this.trainerName = trainerName;
        this.pokemonName = pokemonName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
}
