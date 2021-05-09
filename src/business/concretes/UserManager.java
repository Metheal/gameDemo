package business.concretes;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        this.userDao.add(user);
        System.out.println("Kullanici eklendi: " + user.getEmail());
    }

    @Override
    public void update(User user) {
        this.userDao.update(user);
        System.out.println("Kullanici guncellendi: " + user.getEmail());
    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);
        System.out.println("Kullanici silindi: " + user.getEmail());
    }

    @Override
    public User getById(int id) {
        return this.userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }
}
