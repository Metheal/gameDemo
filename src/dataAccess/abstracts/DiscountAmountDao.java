package dataAccess.abstracts;

import entities.concretes.DiscountAmount;

import java.util.List;

public interface DiscountAmountDao {
    void add(DiscountAmount discountAmount);
    void update(DiscountAmount discountAmount);
    void delete(DiscountAmount discountAmount);
    DiscountAmount getById(int id);
    List<DiscountAmount> getAll();
}
