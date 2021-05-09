package business.concretes;

import business.abstracts.CitizenCheckService;
import business.abstracts.CitizenPlayerService;
import dataAccess.abstracts.CitizenPlayerDao;
import entities.concretes.CitizenPlayer;

import java.util.List;

public class CitizenPlayerManager implements CitizenPlayerService {

    private CitizenPlayerDao citizenPlayerDao;
    private CitizenCheckService citizenCheckService;

    public CitizenPlayerManager(CitizenPlayerDao citizenPlayerDao, CitizenCheckService citizenCheckService) {
        this.citizenPlayerDao = citizenPlayerDao;
        this.citizenCheckService = citizenCheckService;
    }

    @Override
    public void add(CitizenPlayer citizenPlayer) throws Exception {
        if (this.citizenCheckService.CheckIfCitizen(citizenPlayer)) {
            this.citizenPlayerDao.add(citizenPlayer);
            System.out.println("Vatandas bilgileri ile kaydolundu: " + citizenPlayer.getFullName());
        } else {
            System.out.println("Lutfen TC vatandasi bilgilerinizi dogru girin");
        }
    }

    @Override
    public void update(CitizenPlayer citizenPlayer) throws Exception {
        if (this.citizenCheckService.CheckIfCitizen(citizenPlayer)) {
            this.citizenPlayerDao.update(citizenPlayer);
        } else {
            System.out.println("Lutfen TC vatandasi bilgilerinizi dogru girin");
        }
    }

    @Override
    public void delete(CitizenPlayer citizenPlayer) {
        this.citizenPlayerDao.delete(citizenPlayer);
    }

    @Override
    public CitizenPlayer getById(int id) {
        return this.citizenPlayerDao.getById(id);
    }

    @Override
    public List<CitizenPlayer> getAll() {
        return this.citizenPlayerDao.getAll();
    }

    private boolean CheckIfCitizen(CitizenPlayer citizenPlayer) {
        return true;
    }
}
