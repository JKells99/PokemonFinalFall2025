package com.pokemon.pokemon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @Mock
    PokemonRepository pokemonRepository;

    @InjectMocks
    PokemonService pokemonService;

    @Test
    void shouldCreatePokemonAndReturnSaved() {
        Pokemon input = new Pokemon();
        input.setName("Pikachu");
        input.setType("Electric");

        Pokemon saved = new Pokemon();
        saved.setPokemonId(1L);
        saved.setName("Pikachu");
        saved.setType("Electric");

        when(pokemonRepository.save(any(Pokemon.class))).thenReturn(saved);


        Pokemon result = pokemonService.savePokemon(input);
        assertNotNull(result);
        assertEquals(1L, result.getPokemonId());
        assertEquals("Pikachu", result.getName());
        verify(pokemonRepository).save(input);
    }
}
