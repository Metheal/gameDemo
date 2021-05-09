package dataAccess.abstracts;

import entities.concretes.Genre;

import java.util.List;

public interface GenreDao {
    void add(Genre genre);
    void update(Genre genre);
    void delete(Genre genre);
    Genre getById(int id);
    List<Genre> getAll();
}
