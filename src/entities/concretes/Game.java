package entities.concretes;

import entities.abstracts.Entity;

public class Game implements Entity {
    private int id;
    private int platformId;
    private int genreId;
    private String name;
    private double unitPrice;
    private int unitsInStock;

    public Game() {
    }

    public Game(int id, int platformId, int genreId, String name, double unitPrice, int unitsInStock) {
        this.id = id;
        this.platformId = platformId;
        this.genreId = genreId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
}
