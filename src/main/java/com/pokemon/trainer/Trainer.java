package com.pokemon.trainer;

import com.pokemon.pokemon.Pokemon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

//
//### 🧑‍🚀 Trainer
//| Field | Type | Description |
//        |-------|------|-------------|
//        | id | Long | Primary key |
//        | name | String | Trainer’s name |
//        | region | String | Pokémon region (Kanto, Johto, etc.) |
//        | level | int | Skill/experience level |
//
//        ---
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private String name;
    private String region;
    private int level;



}
