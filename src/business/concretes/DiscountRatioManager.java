package business.concretes;

import business.abstracts.DiscountRatioService;
import dataAccess.abstracts.DiscountRatioDao;
import entities.concretes.DiscountRatio;

import java.util.List;

public class DiscountRatioManager implements DiscountRatioService {

    private DiscountRatioDao discountRatioDao;

    public DiscountRatioManager(DiscountRatioDao discountRatioDao) {
        this.discountRatioDao = discountRatioDao;
    }

    @Override
    public void add(DiscountRatio discountRatio) {
        if (discountRatio.getRatio() > 0 && discountRatio.getRatio() < 20) {
            this.discountRatioDao.add(discountRatio);
        } else {
            System.out.println("Indirim orani 0 ila 20 arasinda olmak zorundadir");
        }
    }

    @Override
    public void update(DiscountRatio discountRatio) {
        if (discountRatio.getRatio() > 0 && discountRatio.getRatio() < 20) {
            this.discountRatioDao.update(discountRatio);
        } else {
            System.out.println("Indirim orani 0 ila 20 arasinda olmak zorundadir");
        }
    }

    @Override
    public void delete(DiscountRatio discountRatio) {
        this.discountRatioDao.delete(discountRatio);
    }

    @Override
    public DiscountRatio getById(int id) {
        return this.discountRatioDao.getById(id);
    }

    @Override
    public List<DiscountRatio> getAll() {
        return this.discountRatioDao.getAll();
    }
}
