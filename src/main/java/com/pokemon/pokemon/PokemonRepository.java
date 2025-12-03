package com.pokemon.pokemon;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for Pokemon entities.
 *
 * The method names define query semantics used by Spring Data at runtime.
 */
@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    /** Find Pokemon with an exact name. */
    List<Pokemon> findPokemonByName(String name);

    /** Find Pokemon with an exact type. */
    Iterable<Pokemon> findPokemonByType(String type);

    /** Find Pokemon with an exact type and apply sorting. */
    Iterable<Pokemon> findPokemonByType(String type, Sort sort);

    /** Find Pokemon with matching hit points. */
    Iterable<Pokemon> findPokemonByHitPoints(int hitPoints);

    /** Find Pokemon by their trainer's name. */
    Iterable<Pokemon> findPokemonByTrainer_Name(String trainerName);

    /**
     * Composite finder used by the service fallback. The parameter order
     * corresponds to hitPoints, name and trainer name in the original code.
     */
    Iterable<Pokemon> findAllByHitPointsAndNameAndTrainer_Name(Integer hitPoints, String name, String type);
}
