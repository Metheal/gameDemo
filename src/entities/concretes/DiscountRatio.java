package entities.concretes;

import entities.abstracts.Entity;
import entities.abstracts.Sale;

import java.util.List;

public class DiscountRatio extends Sale implements Entity {
    private double ratio;

    public DiscountRatio() {
    }

    public DiscountRatio(int id, String name, List<Integer> appliedToGenres, List<Integer> appliedToPlatforms, List<Integer> appliedToGames, double ratio) {
        super(id, name, appliedToGenres, appliedToPlatforms, appliedToGames);
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
