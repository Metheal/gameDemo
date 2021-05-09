package business.concretes;

import business.abstracts.GenreService;
import dataAccess.abstracts.GenreDao;
import entities.concretes.Genre;

import java.util.List;

public class GenreManager implements GenreService {

    private GenreDao genreDao;

    public GenreManager(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public void add(Genre genre) {
        this.genreDao.add(genre);
    }

    @Override
    public void update(Genre genre) {
        this.genreDao.update(genre);
    }

    @Override
    public void delete(Genre genre) {
        this.genreDao.delete(genre);
    }

    @Override
    public Genre getById(int id) {
        return this.genreDao.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return this.genreDao.getAll();
    }
}
