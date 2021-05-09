package dataAccess.concretes;

import dataAccess.abstracts.DiscountRatioDao;
import entities.concretes.DiscountRatio;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDiscountRatioDao implements DiscountRatioDao {
    private List<DiscountRatio> discountRatioList = new ArrayList<>();

    @Override
    public void add(DiscountRatio discountRatio) {
        this.discountRatioList.add(discountRatio);
    }

    @Override
    public void update(DiscountRatio discountRatio) {
        DiscountRatio discountRatioToUpdate;
        discountRatioToUpdate = discountRatioList.get(discountRatio.getId());
        discountRatioToUpdate.setName(discountRatio.getName());
        discountRatioToUpdate.setRatio(discountRatio.getRatio());
        discountRatioToUpdate.setAppliedToGames(discountRatio.getAppliedToGames());
        discountRatioToUpdate.setAppliedToGenres(discountRatio.getAppliedToGenres());
        discountRatioToUpdate.setAppliedToPlatforms(discountRatio.getAppliedToPlatforms());
    }

    @Override
    public void delete(DiscountRatio discountRatio) {
        DiscountRatio discountRatioToDelete;
        discountRatioToDelete = discountRatioList.get(discountRatio.getId());
        discountRatioList.remove(discountRatioToDelete);
    }

    @Override
    public DiscountRatio getById(int id) {
        return discountRatioList.stream().filter(d -> d.getId() == id).findFirst().get();
    }

    @Override
    public List<DiscountRatio> getAll() {
        return discountRatioList;
    }
}
