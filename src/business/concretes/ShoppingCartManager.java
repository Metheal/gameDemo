package business.concretes;

import business.abstracts.ShoppingCartService;
import dataAccess.abstracts.ShoppingCartDao;
import entities.concretes.ShoppingCart;

import java.util.List;

public class ShoppingCartManager implements ShoppingCartService {

    private ShoppingCartDao shoppingCartDao;

    public ShoppingCartManager(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    @Override
    public void add(ShoppingCart shoppingCart) {
        this.shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        this.shoppingCartDao.update(shoppingCart);
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        this.shoppingCartDao.delete(shoppingCart);
    }

    @Override
    public ShoppingCart getById(int id) {
        return this.shoppingCartDao.getById(id);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return this.shoppingCartDao.getAll();
    }
}
