package az.java.hospital.dao.imple;

import az.java.hospital.dao.DBhelper;
import az.java.hospital.dao.TreatmentDao;
import az.java.hospital.model.*;
import az.java.hospital.util.JdbcUtily;
import az.java.hospital.util.SqlTreatments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TreatmentDaoImple implements TreatmentDao {


    @Override
    public List<Treatment> getTreatmentList() throws Exception {
        List<Treatment> treatments=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql= SqlTreatments.GET_TREATMENT_LIST;
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
               ps = c.prepareStatement(sql);
               rs=ps.executeQuery();
               while (rs.next()){
                   Treatment treatment=new Treatment();
                   treatment.setR(rs.getLong("r"));
                   treatment.setId(rs.getLong("SC_ID"));
                   Patient patient=new Patient();
                   patient.setId(rs.getLong("P_ID"));
                   patient.setName(rs.getString("P_NAME"));
                   patient.setSurname(rs.getString("P_SURNAME"));
                   Doctor doctor=new Doctor();
                   doctor.setId(rs.getLong("D_ID"));
                   doctor.setName(rs.getString("D_NAME"));
                   doctor.setSurname(rs.getString("D_SURNAME"));
                   Soreness soreness=new Soreness();
                   soreness.setId(rs.getLong("S_ID"));
                   soreness.setDiagonis(rs.getString("DIAGONIS"));
                   soreness.setMedicines(rs.getString("MEDICINES"));
                   treatment.setPatient(patient);
                   treatment.setDoctor(doctor);
                   treatment.setSoreness(soreness);
                   treatments.add(treatment);
               }
            }else{
                System.out.println("Connection is null!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return treatments;
    }

    @Override
    public boolean addTreatment(Treatment treatment) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlTreatments.ADD_TREATMENT;
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,treatment.getPatient().getId());
                ps.setLong(2,treatment.getDoctor().getId());
                ps.setLong(3,treatment.getSoreness().getId());
                ps.execute();
                result=true;
            }else{
                System.out.println("Connection is null!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result=false;
        }finally {
            c.commit();
            JdbcUtily.close(c,ps,null);
        }
        return result;
    }

    @Override
    public Treatment getTreatmentById(Long treatmentId) throws Exception {
        Treatment treatment=new Treatment();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=SqlTreatments.GET_TREATMENT_BY_ID;
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,treatmentId);
                rs = ps.executeQuery();
                if(rs.next()){
                    treatment.setId(rs.getLong("ID"));
                    Patient patient=new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    Doctor doctor=new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    Soreness soreness=new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    treatment.setPatient(patient);
                    treatment.setDoctor(doctor);
                    treatment.setSoreness(soreness);
                }
            }else{
                System.out.println("Connection is null!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            c.commit();
            JdbcUtily.close(c,ps,rs);
        }
        return treatment;
    }

    @Override
    public boolean updateTreatment(Treatment treatment, Long treatmentId) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlTreatments.UPDATE_TREATMENT;
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,treatment.getPatient().getId());
                ps.setLong(2,treatment.getDoctor().getId());
                ps.setLong(3,treatment.getSoreness().getId());
                ps.setLong(4,treatmentId);
                ps.executeUpdate();
                result=true;
            }else{
                System.out.println("Connection is null!");
            }
        }catch (Exception e){
            c.commit();
            e.printStackTrace();
        }finally {
            c.commit();
            JdbcUtily.close(c,ps,null);
        }
        return result;
    }

    @Override
    public boolean deleteTreatment(Long treatmentId) throws Exception {
        boolean result = false;
        Connection c=null;
        PreparedStatement ps = null;
        String sql=SqlTreatments.DELETE_TREATMENT;
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,treatmentId);
                ps.executeUpdate();
                result=true;
            }else {
                System.out.println("Connection is null!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,null);
        }
        return result;
    }

    @Override
    public List<Treatment> seacrhTreatmentData(String keyword) throws Exception {
        List<Treatment> treatments=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=SqlTreatments.GET_TREATMENT_LIST +"AND (LOWER (P.NAME) LIKE LOWER (?)" +
                "OR LOWER (P.SURNAME) LIKE LOWER (?)" +
                "OR LOWER (D.NAME) LIKE LOWER (?) OR LOWER (D.SURNAME) LIKE LOWER (?)" +
                "OR LOWER (S.DIAGONIS) LIKE LOWER (?) OR LOWER (S.MEDICINES) LIKE LOWER (?))";
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
                ps.setString(2,"%"+keyword+"%");
                ps.setString(3,"%"+keyword+"%");
                ps.setString(4,"%"+keyword+"%");
                ps.setString(5,"%"+keyword+"%");
                ps.setString(6,"%"+keyword+"%");
                rs = ps.executeQuery();
                while (rs.next()){
                    Treatment treatment=new Treatment();
                    treatment.setR(rs.getLong("r"));
                    treatment.setId(rs.getLong("SC_ID"));
                    Patient patient=new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("P_NAME"));
                    patient.setSurname(rs.getString("P_SURNAME"));
                    Doctor doctor=new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    Soreness soreness=new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    treatment.setPatient(patient);
                    treatment.setDoctor(doctor);
                    treatment.setSoreness(soreness);
                    treatments.add(treatment);
                }
            }else {
                System.out.println("Connection is null!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return treatments;
    }

    @Override
    public List<Treatment> advanceSearchTreatment(AdvanceSearch advanceSearch) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Treatment> treatments=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql= SqlTreatments.GET_TREATMENT_LIST;
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                if(advanceSearch.getSorenessId()!=0 )
                    sql+=" AND S.ID = "+advanceSearch.getSorenessId();
                if(advanceSearch.getDoctorId()!=0)
                    sql+=" AND D.ID = "+advanceSearch.getDoctorId();
                if (advanceSearch.getBeginDate()!=null && !advanceSearch.getBeginDate().isEmpty())
                    sql+=" AND P.DOB >= TO_DATE('"+new java.sql.Date(df.parse(advanceSearch.getBeginDate()).getTime())+"','YYYY-MM-DD')";
                if (advanceSearch.getEndDate()!=null && !advanceSearch.getEndDate().isEmpty())
                    sql+=" AND P.DOB < TO_DATE('"+new java.sql.Date(df.parse(advanceSearch.getEndDate()).getTime())+"','YYYY-MM-DD')";
                ps = c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){
                    Treatment treatment=new Treatment();
                    treatment.setR(rs.getLong("r"));
                    treatment.setId(rs.getLong("SC_ID"));
                    Patient patient=new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("P_NAME"));
                    patient.setSurname(rs.getString("P_SURNAME"));
                    Doctor doctor=new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    Soreness soreness=new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    treatment.setPatient(patient);
                    treatment.setDoctor(doctor);
                    treatment.setSoreness(soreness);
                    treatments.add(treatment);
                }
            }else{
                System.out.println("Connection is null!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return treatments;

           }
}
