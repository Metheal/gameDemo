package business.abstracts;

import entities.concretes.DiscountAmount;

import java.util.List;

public interface DiscountAmountService {
    void add(DiscountAmount discountAmount);
    void update(DiscountAmount discountAmount);
    void delete(DiscountAmount discountAmount);
    DiscountAmount getById(int id);
    List<DiscountAmount> getAll();
}
