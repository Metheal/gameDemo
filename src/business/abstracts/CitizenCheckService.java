package business.abstracts;

import entities.concretes.CitizenPlayer;

public interface CitizenCheckService {
    boolean CheckIfCitizen(CitizenPlayer citizenPlayer) throws Exception;
}
