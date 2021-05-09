package business.concretes;

import business.abstracts.PlayerService;
import dataAccess.abstracts.PlayerDao;
import entities.abstracts.Player;

import java.util.List;

public class PlayerManager implements PlayerService {

    private PlayerDao playerDao;

    public PlayerManager(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Override
    public void add(Player player) {
        this.playerDao.add(player);
    }

    @Override
    public void update(Player player) {
        this.playerDao.update(player);
    }

    @Override
    public void delete(Player player) {
        this.playerDao.delete(player);
    }

    @Override
    public Player getById(int id) {
        return this.playerDao.getById(id);
    }

    @Override
    public List<Player> getAll() {
        return this.playerDao.getAll();
    }
}
