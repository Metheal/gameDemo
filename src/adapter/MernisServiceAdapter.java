package adapter;

import business.abstracts.CitizenCheckService;
import entities.concretes.CitizenPlayer;
import mernisServiceReference.EPFKPSPublicSoap;

public class MernisServiceAdapter implements CitizenCheckService {
    @Override
    public boolean CheckIfCitizen(CitizenPlayer citizenPlayer) throws Exception {
        return new EPFKPSPublicSoap().TCKimlikNoDogrula(Long.parseLong(citizenPlayer.getNationalityId()), citizenPlayer.getFirstName(), citizenPlayer.getLastName(), citizenPlayer.getDateOfBirth().getYear());
    }
}
