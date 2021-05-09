package business.abstracts;

import entities.abstracts.Player;

import java.util.List;

public interface PlayerService {
    void add(Player player);
    void update(Player player);
    void delete(Player player);
    Player getById(int id);
    List<Player> getAll();
}
