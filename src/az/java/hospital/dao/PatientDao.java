package az.java.hospital.dao;

import az.java.hospital.model.Patient;

import java.util.List;

public interface PatientDao {

    List<Patient> patientList () throws Exception;

    boolean addPatient (Patient patient) throws Exception;

    Patient getPatientById (Long patientId) throws Exception;

    boolean updatePatient (Patient patient, Long patientId) throws Exception;

    boolean deletePatient (Long patientId) throws Exception;

    List<Patient> searchPatient(String keyword) throws Exception;
}
