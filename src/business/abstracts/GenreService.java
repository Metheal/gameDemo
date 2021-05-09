package business.abstracts;

import entities.concretes.Genre;

import java.util.List;

public interface GenreService {
    void add(Genre genre);
    void update(Genre genre);
    void delete(Genre genre);
    Genre getById(int id);
    List<Genre> getAll();
}
