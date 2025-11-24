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
@Data
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

}
