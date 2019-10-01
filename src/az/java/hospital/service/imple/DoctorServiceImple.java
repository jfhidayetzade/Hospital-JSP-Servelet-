package az.java.hospital.service.imple;

import az.java.hospital.dao.DoctorDao;
import az.java.hospital.model.Doctor;
import az.java.hospital.service.DoctorService;

import java.util.List;

public class DoctorServiceImple implements DoctorService {
    private DoctorDao doctorDao;

    public DoctorServiceImple(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public List<Doctor> doctors() throws Exception {
        return doctorDao.doctors();
    }

    @Override
    public boolean addDoctor(Doctor doctor) throws Exception {
        return doctorDao.addDoctor(doctor);
    }

    @Override
    public Doctor getDoctorById(Long doctorId) throws Exception {
        return doctorDao.getDoctorById(doctorId);
    }

    @Override
    public boolean updateDoctor(Doctor doctor, Long doctorId) throws Exception {
        return doctorDao.updateDoctor(doctor,doctorId);
    }

    @Override
    public boolean deleteDoctor(Long doctorId) throws Exception {
        return doctorDao.deleteDoctor(doctorId);
    }

    @Override
    public List<Doctor> getDoctorComboSorenessById(Long sorenessId) throws Exception {
        return doctorDao.getDoctorComboSorenessById(sorenessId);
    }

    @Override
    public List<Doctor> searchDoctor(String keyword) throws Exception {
        return doctorDao.searchDoctor(keyword);
    }
}
