package dataAccess.abstracts;

import entities.concretes.DiscountRatio;

import java.util.List;

public interface DiscountRatioDao {
    void add(DiscountRatio discountRatio);
    void update(DiscountRatio discountRatio);
    void delete(DiscountRatio discountRatio);
    DiscountRatio getById(int id);
    List<DiscountRatio> getAll();
}
