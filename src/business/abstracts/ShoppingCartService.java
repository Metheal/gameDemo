package business.abstracts;

import entities.concretes.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    void add(ShoppingCart shoppingCart);
    void update(ShoppingCart shoppingCart);
    void delete(ShoppingCart shoppingCart);
    ShoppingCart getById(int id);
    List<ShoppingCart> getAll();
}
