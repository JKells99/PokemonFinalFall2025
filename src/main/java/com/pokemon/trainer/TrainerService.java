package com.pokemon.trainer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;
}
