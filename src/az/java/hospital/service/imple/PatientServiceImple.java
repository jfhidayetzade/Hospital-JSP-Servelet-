package az.java.hospital.service.imple;

import az.java.hospital.dao.PatientDao;
import az.java.hospital.model.Patient;
import az.java.hospital.service.PatientService;

import java.util.List;

public class PatientServiceImple  implements PatientService {

    private PatientDao patientDao;

    public PatientServiceImple(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<Patient> patientList() throws Exception {
        return patientDao.patientList();
    }

    @Override
    public boolean addPatient(Patient patient) throws Exception {
        return patientDao.addPatient(patient);
    }

    @Override
    public Patient getPatientById(Long patientId) throws Exception {
        return patientDao.getPatientById(patientId);
    }

    @Override
    public boolean updatePatient(Patient patient, Long patientId) throws Exception {
        return patientDao.updatePatient(patient,patientId);
    }

    @Override
    public boolean deletePatient(Long patientId) throws Exception {
        return patientDao.deletePatient(patientId);
    }

    @Override
    public List<Patient> searchPatient(String keyword) throws Exception {
        return patientDao.searchPatient(keyword);
    }
}
