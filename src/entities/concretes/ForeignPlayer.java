package entities.concretes;

import entities.abstracts.Entity;
import entities.abstracts.Player;

import java.time.LocalDate;

public class ForeignPlayer extends Player implements Entity {
    private String passportNumber;

    public ForeignPlayer() {
    }

    public ForeignPlayer(int id, int userId, String firstName, String lastName, LocalDate dateOfBirth, int countryId, String passportNumber) {
        super(id, userId, firstName, lastName, dateOfBirth, countryId);
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
