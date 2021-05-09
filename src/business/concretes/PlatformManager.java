package business.concretes;

import business.abstracts.PlatformService;
import dataAccess.abstracts.PlatformDao;
import entities.concretes.Platform;

import java.util.List;

public class PlatformManager implements PlatformService {

    private PlatformDao platformDao;

    public PlatformManager(PlatformDao platformDao) {
        this.platformDao = platformDao;
    }

    @Override
    public void add(Platform platform) {
        this.platformDao.add(platform);
    }

    @Override
    public void update(Platform platform) {
        this.platformDao.update(platform);
    }

    @Override
    public void delete(Platform platform) {
        this.platformDao.delete(platform);
    }

    @Override
    public Platform getById(int id) {
        return this.platformDao.getById(id);
    }

    @Override
    public List<Platform> getAll() {
        return this.platformDao.getAll();
    }
}
