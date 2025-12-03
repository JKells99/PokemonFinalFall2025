package com.pokemon.pokeball;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokeBallRepository extends JpaRepository<PokeBall, Long> {
    Optional<PokeBall> findPokeBallByType(String type);
}
