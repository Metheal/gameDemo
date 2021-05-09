package dataAccess.concretes;

import dataAccess.abstracts.CitizenPlayerDao;
import entities.concretes.CitizenPlayer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCitizenPlayerDao implements CitizenPlayerDao {
    private List<CitizenPlayer> citizenPlayerList = new ArrayList<>();

    @Override
    public void add(CitizenPlayer citizenPlayer) {
        this.citizenPlayerList.add(citizenPlayer);
    }

    @Override
    public void update(CitizenPlayer citizenPlayer) {
        CitizenPlayer citizenPlayerToUpdate;
        citizenPlayerToUpdate = citizenPlayerList.get(citizenPlayer.getId());
        citizenPlayerToUpdate.setUserId(citizenPlayer.getUserId());
        citizenPlayerToUpdate.setFirstName(citizenPlayer.getFirstName());
        citizenPlayerToUpdate.setLastName(citizenPlayer.getLastName());
        citizenPlayerToUpdate.setDateOfBirth(citizenPlayer.getDateOfBirth());
        citizenPlayerToUpdate.setNationalityId(citizenPlayer.getNationalityId());
    }

    @Override
    public void delete(CitizenPlayer citizenPlayer) {
        CitizenPlayer citizenPlayerToDelete;
        citizenPlayerToDelete = citizenPlayerList.get(citizenPlayer.getId());
        citizenPlayerList.remove(citizenPlayerToDelete);
    }

    @Override
    public CitizenPlayer getById(int id) {
        return citizenPlayerList.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    @Override
    public List<CitizenPlayer> getAll() {
        return citizenPlayerList;
    }
}
