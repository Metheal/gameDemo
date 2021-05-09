package entities.abstracts;

import java.util.List;

public abstract class Sale {
    private int id;
    private String name;
    private List<Integer> appliedToGenres;
    private List<Integer> appliedToPlatforms;
    private List<Integer> appliedToGames;

    public Sale() {
    }

    public Sale(int id, String name, List<Integer> appliedToGenres, List<Integer> appliedToPlatforms, List<Integer> appliedToGames) {
        this.id = id;
        this.name = name;
        this.appliedToGenres = appliedToGenres;
        this.appliedToPlatforms = appliedToPlatforms;
        this.appliedToGames = appliedToGames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAppliedToGenres() {
        return appliedToGenres;
    }

    public void setAppliedToGenres(List<Integer> appliedToGenres) {
        this.appliedToGenres = appliedToGenres;
    }

    public List<Integer> getAppliedToPlatforms() {
        return appliedToPlatforms;
    }

    public void setAppliedToPlatforms(List<Integer> appliedToPlatforms) {
        this.appliedToPlatforms = appliedToPlatforms;
    }

    public List<Integer> getAppliedToGames() {
        return appliedToGames;
    }

    public void setAppliedToGames(List<Integer> appliedToGames) {
        this.appliedToGames = appliedToGames;
    }
}
