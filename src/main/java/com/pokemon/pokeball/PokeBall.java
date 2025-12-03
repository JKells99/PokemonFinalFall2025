package com.pokemon.pokeball;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PokeBall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pokeBallId;
    private String type;
    private int quantity;


    public PokeBall(Long pokeBallId, String type, int quantity) {
        this.pokeBallId = pokeBallId;
        this.type = type;
        this.quantity = quantity;
    }

    public PokeBall(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }
    public PokeBall() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPokeBallId() {
        return pokeBallId;
    }

    public void setPokeBallId(Long pokeBallId) {
        this.pokeBallId = pokeBallId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PokeBall(String type) {
        this.type = type;
    }
    // Methods


}
