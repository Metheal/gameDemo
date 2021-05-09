package business.concretes;

import business.abstracts.DiscountAmountService;
import dataAccess.abstracts.DiscountAmountDao;
import entities.concretes.DiscountAmount;

import java.util.List;

public class DiscountAmountManager implements DiscountAmountService {

    private DiscountAmountDao discountAmountDao;

    public DiscountAmountManager(DiscountAmountDao discountAmountDao) {
        this.discountAmountDao = discountAmountDao;
    }

    @Override
    public void add(DiscountAmount discountAmount) {
        this.discountAmountDao.add(discountAmount);
    }

    @Override
    public void update(DiscountAmount discountAmount) {
        this.discountAmountDao.update(discountAmount);
    }

    @Override
    public void delete(DiscountAmount discountAmount) {
        this.discountAmountDao.delete(discountAmount);
    }

    @Override
    public DiscountAmount getById(int id) {
        return this.discountAmountDao.getById(id);
    }

    @Override
    public List<DiscountAmount> getAll() {
        return this.discountAmountDao.getAll();
    }
}
