package business.abstracts;

import entities.concretes.CitizenPlayer;

import java.util.List;

public interface CitizenPlayerService {
    void add(CitizenPlayer citizenPlayer) throws Exception;
    void update(CitizenPlayer citizenPlayer) throws Exception;
    void delete(CitizenPlayer citizenPlayer);
    CitizenPlayer getById(int id);
    List<CitizenPlayer> getAll();
}
