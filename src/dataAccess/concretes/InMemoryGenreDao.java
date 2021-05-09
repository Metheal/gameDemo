package dataAccess.concretes;

import dataAccess.abstracts.GenreDao;
import entities.concretes.Genre;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGenreDao implements GenreDao {
    private List<Genre> genreList = new ArrayList<>();

    @Override
    public void add(Genre genre) {
        genreList.add(genre);
    }

    @Override
    public void update(Genre genre) {
        Genre genreToUpdate;
        genreToUpdate = genreList.get(genre.getId());
        genreToUpdate.setName(genre.getName());
    }

    @Override
    public void delete(Genre genre) {
        Genre genreToDelete;
        genreToDelete = genreList.get(genre.getId());
        genreList.remove(genre);
    }

    @Override
    public Genre getById(int id) {
        return genreList.stream().filter(g -> g.getId() == id).findFirst().get();
    }

    @Override
    public List<Genre> getAll() {
        return genreList;
    }
}
