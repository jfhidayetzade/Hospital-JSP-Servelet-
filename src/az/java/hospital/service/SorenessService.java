package az.java.hospital.service;

import az.java.hospital.model.Soreness;

import java.util.List;

public interface SorenessService {

    List<Soreness> sorenessList () throws Exception;

    boolean addSoreness(Soreness soreness) throws Exception;

    Soreness getSorenessById(Long sorenessId) throws Exception;

    boolean updateSoreness(Soreness soreness,Long sorenessId) throws Exception;

    boolean deleteSoreness(Long sorenessId) throws Exception;

    List<Soreness> searchSoreness(String keyword) throws Exception;
}
