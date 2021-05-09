package entities.concretes;

import entities.abstracts.Entity;
import entities.abstracts.Player;

import java.util.List;

public class ShoppingCart implements Entity {
    private int id;
    private List<Game> gamesList;
    private Player player;
    private DiscountRatio discountRatio;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, List<Game> gamesList, Player player, DiscountRatio discountRatio) {
        this.id = id;
        this.gamesList = gamesList;
        this.player = player;
        this.discountRatio = discountRatio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Game> gamesList) {
        this.gamesList = gamesList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public DiscountRatio getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(DiscountRatio discountRatio) {
        this.discountRatio = discountRatio;
    }
}
