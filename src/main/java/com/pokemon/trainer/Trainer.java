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
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private String name;
    private String region;
    private int level;

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
