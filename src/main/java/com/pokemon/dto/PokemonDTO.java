package com.pokemon.dto;


public class PokemonDTO {
    private long id;
    private String name;
    private String type;
    private int hitPoints;

    public PokemonDTO(long id, String name, String type, int hitPoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hitPoints = hitPoints;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
