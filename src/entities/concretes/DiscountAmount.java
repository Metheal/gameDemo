package entities.concretes;

import entities.abstracts.Entity;
import entities.abstracts.Sale;

import java.util.List;

public class DiscountAmount extends Sale implements Entity {
    private double amount;

    public DiscountAmount() {
    }

    public DiscountAmount(int id, String name, List<Integer> appliedToGenres, List<Integer> appliedToPlatforms, List<Integer> appliedToGames, double amount) {
        super(id, name, appliedToGenres, appliedToPlatforms, appliedToGames);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
