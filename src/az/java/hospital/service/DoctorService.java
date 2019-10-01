package az.java.hospital.service;

import az.java.hospital.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> doctors () throws Exception;

    boolean addDoctor(Doctor doctor) throws Exception;

    Doctor getDoctorById (Long doctorId) throws Exception;

    boolean updateDoctor(Doctor doctor,Long doctorId) throws Exception;

    boolean deleteDoctor(Long doctorId) throws Exception;

    List<Doctor> getDoctorComboSorenessById(Long sorenessId) throws Exception;

    List<Doctor> searchDoctor(String keyword) throws Exception;
}
