package business.concretes;

import business.abstracts.GameService;
import dataAccess.abstracts.GameDao;
import entities.concretes.Game;

import java.util.List;

public class GameManager implements GameService {

    private GameDao gameDao;

    public GameManager(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public void add(Game game) {
        this.gameDao.add(game);
    }

    @Override
    public void update(Game game) {
        this.gameDao.update(game);
    }

    @Override
    public void delete(Game game) {
        this.gameDao.delete(game);
    }

    @Override
    public Game getById(int id) {
        return this.gameDao.getById(id);
    }

    @Override
    public List<Game> getAll() {
        return this.gameDao.getAll();
    }
}
