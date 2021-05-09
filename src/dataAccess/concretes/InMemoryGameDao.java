package dataAccess.concretes;

import dataAccess.abstracts.GameDao;
import entities.concretes.Game;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGameDao implements GameDao {
    private List<Game> gameList = new ArrayList<>();

    @Override
    public void add(Game game) {
        this.gameList.add(game);
    }

    @Override
    public void update(Game game) {
        Game gameToUpdate;
        gameToUpdate = gameList.get(game.getId());
        gameToUpdate.setName(game.getName());
        gameToUpdate.setGenreId(game.getGenreId());
        gameToUpdate.setPlatformId(game.getPlatformId());
        gameToUpdate.setUnitPrice(game.getUnitPrice());
        gameToUpdate.setUnitsInStock(game.getUnitsInStock());
    }

    @Override
    public void delete(Game game) {
        Game gameToDelete;
        gameToDelete = gameList.get(game.getId());
        gameList.remove(gameToDelete);
    }

    @Override
    public Game getById(int id) {
        return gameList.stream().filter(g -> g.getId() == id).findFirst().get();
    }

    @Override
    public List<Game> getAll() {
        return gameList;
    }
}
