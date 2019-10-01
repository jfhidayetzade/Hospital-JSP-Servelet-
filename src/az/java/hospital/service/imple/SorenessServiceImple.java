package az.java.hospital.service.imple;

import az.java.hospital.dao.SorenessDao;
import az.java.hospital.model.Soreness;
import az.java.hospital.service.SorenessService;

import java.util.List;

public class SorenessServiceImple implements SorenessService {
    private SorenessDao sorenessDao;

    public SorenessServiceImple(SorenessDao sorenessDao) {
        this.sorenessDao = sorenessDao;
    }

    @Override
    public List<Soreness> sorenessList() throws Exception {
        return sorenessDao.sorenessList();
    }

    @Override
    public boolean addSoreness(Soreness soreness) throws Exception {
        return sorenessDao.addSoreness(soreness);
    }

    @Override
    public Soreness getSorenessById(Long sorenessId) throws Exception {
        return sorenessDao.getSorenessById(sorenessId);
    }

    @Override
    public boolean updateSoreness(Soreness soreness, Long sorenessId) throws Exception {
        return sorenessDao.updateSoreness(soreness,sorenessId);
    }

    @Override
    public boolean deleteSoreness(Long sorenessId) throws Exception {
        return sorenessDao.deleteSoreness(sorenessId);
    }

    @Override
    public List<Soreness> searchSoreness(String keyword) throws Exception {
        return sorenessDao.searchSoreness(keyword);
    }
}
