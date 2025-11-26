package com.pokemon.pokemon;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Iterable<Pokemon> findPokemonByName(String name);

    Iterable<Pokemon> findPokemonByType(String type);

    Iterable<Pokemon> findPokemonByType(String type, Sort sort);

    Iterable<Pokemon> findPokemonByHitPoints(int hitPoints);

    Iterable<Pokemon> findPokemonByTrainer_Name(String trainerName);
}
