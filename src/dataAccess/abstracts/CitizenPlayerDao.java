package dataAccess.abstracts;

import entities.concretes.CitizenPlayer;

import java.util.List;

public interface CitizenPlayerDao {
    void add(CitizenPlayer citizenPlayer);
    void update(CitizenPlayer citizenPlayer);
    void delete(CitizenPlayer citizenPlayer);
    CitizenPlayer getById(int id);
    List<CitizenPlayer> getAll();
}
