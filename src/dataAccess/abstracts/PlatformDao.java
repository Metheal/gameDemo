package dataAccess.abstracts;

import entities.concretes.Platform;

import java.util.List;

public interface PlatformDao {
    void add(Platform platform);
    void update(Platform platform);
    void delete(Platform platform);
    Platform getById(int id);
    List<Platform> getAll();
}
