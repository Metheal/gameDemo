package entities.concretes;

import entities.abstracts.Entity;
import entities.abstracts.Player;

import java.time.LocalDate;

public class CitizenPlayer extends Player implements Entity {
    private String nationalityId;

    public CitizenPlayer() {
    }

    public CitizenPlayer(int id, int userId, String firstName, String lastName, LocalDate dateOfBirth, int countryId, String nationalityId) {
        super(id, userId, firstName, lastName, dateOfBirth, countryId);
        this.nationalityId = nationalityId;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }
}
