package dataAccess.concretes;

import dataAccess.abstracts.PlayerDao;
import entities.abstracts.Player;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPlayerDao implements PlayerDao {
    private List<Player> playerList = new ArrayList<>();

    @Override
    public void add(Player player) {
        playerList.add(player);
    }

    @Override
    public void update(Player player) {
        Player playerToUpdate;
        playerToUpdate = playerList.get(player.getId());
        playerToUpdate.setFirstName(player.getFirstName());
        playerToUpdate.setLastName(player.getLastName());
        playerToUpdate.setDateOfBirth(player.getDateOfBirth());
        playerToUpdate.setUserId(player.getUserId());
    }

    @Override
    public void delete(Player player) {
        Player playerToDelete;
        playerToDelete = playerList.get(player.getId());
        playerList.remove(playerToDelete);
    }

    @Override
    public Player getById(int id) {
        return playerList.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    @Override
    public List<Player> getAll() {
        return playerList;
    }
}
