package dataAccess.concretes;

import dataAccess.abstracts.DiscountAmountDao;
import entities.concretes.DiscountAmount;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDiscountAmountDao implements DiscountAmountDao {
    private List<DiscountAmount> discountAmountList = new ArrayList<>();

    @Override
    public void add(DiscountAmount discountAmount) {
        this.discountAmountList.add(discountAmount);
    }

    @Override
    public void update(DiscountAmount discountAmount) {
        DiscountAmount discountAmountToUpdate;
        discountAmountToUpdate = discountAmountList.get(discountAmount.getId());
        discountAmountToUpdate.setName(discountAmount.getName());
        discountAmountToUpdate.setAmount(discountAmount.getAmount());
        discountAmountToUpdate.setAppliedToGames(discountAmount.getAppliedToGames());
        discountAmountToUpdate.setAppliedToGenres(discountAmount.getAppliedToGenres());
        discountAmountToUpdate.setAppliedToPlatforms(discountAmount.getAppliedToPlatforms());
    }

    @Override
    public void delete(DiscountAmount discountAmount) {
        DiscountAmount discountAmountToDelete;
        discountAmountToDelete = discountAmountList.get(discountAmount.getId());
        discountAmountList.remove(discountAmountToDelete);
    }

    @Override
    public DiscountAmount getById(int id) {
        return discountAmountList.stream().filter(d -> d.getId() == id).findFirst().get();
    }

    @Override
    public List<DiscountAmount> getAll() {
        return discountAmountList;
    }
}
