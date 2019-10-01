package az.java.hospital.service.imple;

import az.java.hospital.dao.TreatmentDao;
import az.java.hospital.model.AdvanceSearch;
import az.java.hospital.model.Treatment;
import az.java.hospital.service.TreatmentService;

import java.util.List;

public class TreatmentServiceImple implements TreatmentService {
    private TreatmentDao treatmentDao;

    public TreatmentServiceImple(TreatmentDao treatmentDao) {
        this.treatmentDao = treatmentDao;
    }

    @Override
    public List<Treatment> getTreatmentList() throws Exception {
        return treatmentDao.getTreatmentList();
    }

    @Override
    public boolean addTreatment(Treatment treatment) throws Exception {
        return treatmentDao.addTreatment(treatment);
    }

    @Override
    public Treatment getTreatmentById(Long treatmentId) throws Exception {
        return treatmentDao.getTreatmentById(treatmentId);
    }

    @Override
    public boolean updateTreatment(Treatment treatment, Long treatmentId) throws Exception {
        return treatmentDao.updateTreatment(treatment,treatmentId);
    }

    @Override
    public boolean deleteTreatment(Long treatmentId) throws Exception {
        return treatmentDao.deleteTreatment(treatmentId);
    }

    @Override
    public List<Treatment> seacrhTreatmentData(String keyword) throws Exception {
        return treatmentDao.seacrhTreatmentData(keyword);
    }

    @Override
    public List<Treatment> advanceSearchTreatment(AdvanceSearch advanceSearch) throws Exception {
        return treatmentDao.advanceSearchTreatment(advanceSearch);
    }
}
