package az.java.hospital.dao.imple;

import az.java.hospital.dao.DBhelper;
import az.java.hospital.dao.PatientDao;
import az.java.hospital.model.Patient;
import az.java.hospital.util.JdbcUtily;
import az.java.hospital.util.SqlConstans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImple implements PatientDao {
    @Override
    public List<Patient> patientList() throws Exception {
        List<Patient> patients=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql= SqlConstans.GET_PATIENT_LIST;
        try {
            c= DBhelper.getconnetion();
            if(c!=null){
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){
                    Patient patient=new Patient();
                    patient.setR(rs.getLong("r"));
                    patient.setId(rs.getLong("ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    patient.setGender(rs.getString("GENDER"));
                    patient.setDob(rs.getDate("DOB"));
                    patient.setEmailAdress(rs.getString("EMAIL_ADRESS"));
                    patient.setAddress(rs.getString("ADDRESS"));
                    patients.add(patient);
                }
            }else{
                System.out.println("Connection is null!");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {

        }
        return patients;
    }

    @Override
    public boolean addPatient(Patient patient) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlConstans.ADD_PATIENT;
        try{
          c =  DBhelper.getconnetion();
          if(c!=null){
            ps=c.prepareStatement(sql);
            ps.setString(1,patient.getName());
            ps.setString(2,patient.getSurname());
            ps.setString(3,patient.getGender());
            ps.setDate(4,new java.sql.Date(patient.getDob().getTime()));
            ps.setString(5,patient.getEmailAdress());
            ps.setString(6,patient.getAddress());
            ps.execute();
            result=true;

          }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Patient getPatientById(Long patientId) throws Exception {
        Patient patient=new Patient();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=SqlConstans.GET_PATIENT_BY_ID;
        try{
           c = DBhelper.getconnetion();
           if(c!=null){
               ps=c.prepareStatement(sql);
               ps.setLong(1,patientId);
               rs=ps.executeQuery();
               if(rs.next()){
                   patient.setId(rs.getLong("ID"));
                   patient.setName(rs.getString("NAME"));
                   patient.setSurname(rs.getString("SURNAME"));
                   patient.setGender(rs.getString("GENDER"));
                   patient.setDob(rs.getDate("DOB"));
                   patient.setEmailAdress(rs.getString("EMAIL_ADRESS"));
                   patient.setAddress(rs.getString("ADDRESS"));
               }

           }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return patient;
    }

    @Override
    public boolean updatePatient(Patient patient, Long patientId) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql="UPDATE PATIENT SET NAME=?, SURNAME=?, GENDER=?, DOB=?, EMAIL_ADRESS=?, ADDRESS=?\n" +
                "WHERE ID=?";
        try{
            c=DBhelper.getconnetion();
            if(c!=null){
                ps=c.prepareStatement(sql);
                ps.setString(1,patient.getName());
                ps.setString(2,patient.getSurname());
                ps.setString(3,patient.getGender());
                ps.setDate(4, new java.sql.Date(patient.getDob().getTime()));
                ps.setString(5,patient.getEmailAdress());
                ps.setString(6,patient.getAddress());
                ps.setLong(7,patientId);
                ps.executeUpdate();
                result=true;
            }else{
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
    public boolean deletePatient(Long patientId) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlConstans.DELETE_PATIENT;
        try{
            c =  DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,patientId);
                ps.executeUpdate();
                result=true;
            }else {
                System.out.println("Connection is null!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Patient> searchPatient(String keyword) throws Exception {
        List<Patient> patients=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ROWNUM r, ID,NAME,SURNAME,GENDER,DOB,EMAIL_ADRESS,ADDRESS FROM PATIENT\n" +
                "WHERE ACTIVE=1 AND (LOWER(NAME) LIKE LOWER ('%"+keyword+"%')" +
                "OR LOWER (SURNAME) LIKE LOWER ('%"+keyword+"%')"+
                "OR LOWER (GENDER) LIKE LOWER ('%"+keyword+"%')"+
                "OR LOWER (DOB) LIKE LOWER ('%"+keyword+"%')"+
                "OR LOWER (EMAIL_ADRESS) LIKE LOWER ('%"+keyword+"%')"+
                "OR LOWER (ADDRESS) LIKE LOWER ('%"+keyword+"%'))";
        try{
            c = DBhelper.getconnetion();
            ps=c.prepareStatement(sql);
            if(c!=null){
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Patient patient=new Patient();
                    patient.setR(rs.getLong("r"));
                    patient.setId(rs.getLong("ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    patient.setGender(rs.getString("GENDER"));
                    patient.setDob(rs.getDate("DOB"));
                    patient.setEmailAdress(rs.getString("EMAIL_ADRESS"));
                    patient.setAddress(rs.getString("ADDRESS"));
                    patients.add(patient);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return patients;
    }
}
