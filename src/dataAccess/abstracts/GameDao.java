package dataAccess.abstracts;

import entities.concretes.Game;

import java.util.List;

public interface GameDao {
    void add(Game game);
    void update(Game game);
    void delete(Game game);
    Game getById(int id);
    List<Game> getAll();
}
