package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {
    private List<User> userList = new ArrayList<>();

    @Override
    public void add(User user) {
        this.userList.add(user);
    }

    @Override
    public void update(User user) {
        User userToUpdate;
        userToUpdate = userList.get(user.getId());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
    }

    @Override
    public void delete(User user) {
        User userToDelete;
        userToDelete = userList.get(user.getId());
        userList.remove(userToDelete);
    }

    @Override
    public User getById(int id) {
        return userList.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
