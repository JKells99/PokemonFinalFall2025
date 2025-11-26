package com.pokemon.pokemon;

import com.pokemon.trainer.Trainer;
import jakarta.persistence.*;
import lombok.*;

//### 🐉 Pokémon
//| Field | Type | Description |
//        |-------|------|-------------|
//        | id | Long | Primary key |
//        | name | String | Pokémon name |
//        | type | String | Fire, Water, Grass, etc. |
//        | hitPoints | int | HP value |
//        | trainer | Trainer | FK reference to Trainer |

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pokemonId;
    private String name;
    private String type;
    private int hitPoints;
    @ManyToOne
    private Trainer trainer;

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
