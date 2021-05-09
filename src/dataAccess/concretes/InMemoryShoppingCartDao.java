package dataAccess.concretes;

import dataAccess.abstracts.ShoppingCartDao;
import entities.concretes.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingCartDao implements ShoppingCartDao {
    private List<ShoppingCart> shoppingCartList = new ArrayList<>();

    @Override
    public void add(ShoppingCart shoppingCart) {
        this.shoppingCartList.add(shoppingCart);
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        ShoppingCart shoppingCartToUpdate;
        shoppingCartToUpdate = this.shoppingCartList.get(shoppingCart.getId());
        shoppingCartToUpdate.setGamesList(shoppingCart.getGamesList());
        shoppingCartToUpdate.setDiscountRatio(shoppingCart.getDiscountRatio());
        shoppingCartToUpdate.setPlayer(shoppingCart.getPlayer());
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        ShoppingCart shoppingCartToDelete;
        shoppingCartToDelete = shoppingCartList.get(shoppingCart.getId());
        shoppingCartList.remove(shoppingCartToDelete.getId());
    }

    @Override
    public ShoppingCart getById(int id) {
        return shoppingCartList.get(id);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return shoppingCartList;
    }
}
