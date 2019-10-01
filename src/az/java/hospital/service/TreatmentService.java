package az.java.hospital.service;

import az.java.hospital.model.AdvanceSearch;
import az.java.hospital.model.Treatment;

import java.util.List;

public interface TreatmentService {

    List<Treatment> getTreatmentList () throws Exception;

    boolean addTreatment (Treatment treatment) throws Exception;

    Treatment getTreatmentById(Long treatmentId) throws Exception;

    boolean updateTreatment(Treatment treatment, Long treatmentId) throws Exception;

    boolean deleteTreatment(Long treatmentId) throws Exception;

    List<Treatment> seacrhTreatmentData(String keyword) throws Exception;

    List<Treatment> advanceSearchTreatment(AdvanceSearch advanceSearch) throws Exception;
}
