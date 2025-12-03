package com.pokemon.pokeball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class PokeBallService {

    @Autowired
    PokeBallRepository pokeBallRepository;

    public PokeBall saveNewPokeBall(PokeBall pokeBall) {
        return pokeBallRepository.save(pokeBall);
    }


    public Optional<PokeBall> findPokeBallByType(String type) {
        return pokeBallRepository.findPokeBallByType(type);
    }
}
