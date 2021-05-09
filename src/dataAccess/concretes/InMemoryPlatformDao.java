package dataAccess.concretes;

import dataAccess.abstracts.PlatformDao;
import entities.concretes.Platform;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPlatformDao implements PlatformDao {
    private List<Platform> platformList = new ArrayList<>();

    @Override
    public void add(Platform platform) {
        platformList.add(platform);
    }

    @Override
    public void update(Platform platform) {
        Platform platformToUpdate;
        platformToUpdate = platformList.get(platform.getId());
        platformToUpdate.setName(platform.getName());
    }

    @Override
    public void delete(Platform platform) {
        Platform platformToDelete;
        platformToDelete = platformList.get(platform.getId());
        platformList.remove(platformToDelete);
    }

    @Override
    public Platform getById(int id) {
        return platformList.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    @Override
    public List<Platform> getAll() {
        return platformList;
    }
}
