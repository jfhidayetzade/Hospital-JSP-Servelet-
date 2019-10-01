package az.java.hospital.dao.imple;

import az.java.hospital.dao.DBhelper;
import az.java.hospital.dao.DoctorDao;
import az.java.hospital.model.Doctor;
import az.java.hospital.util.JdbcUtily;
import az.java.hospital.util.SqlConstans;
import az.java.hospital.util.SqlDoctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImple implements DoctorDao {

    @Override
    public List<Doctor> doctors() throws Exception {
        List<Doctor> doctors=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=SqlDoctor.GET_DOCTOR_LIST;
        try{
            c=DBhelper.getconnetion();
            if(c!=null){
               ps = c.prepareStatement(sql);
               rs = ps.executeQuery();
               while (rs.next()){
                   Doctor doctor=new Doctor();
                   doctor.setR(rs.getLong("r"));
                   doctor.setId(rs.getLong("ID"));
                   doctor.setName(rs.getString("NAME"));
                   doctor.setSurname(rs.getString("SURNAME"));
                   doctor.setTask(rs.getString("TASK"));
                   doctor.setDepartament(rs.getString("DEPARTAMENT"));
                   doctors.add(doctor);
               }
            }else {
                System.out.println("Connection is null!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return doctors;
    }

    @Override
    public boolean addDoctor(Doctor doctor) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql= SqlDoctor.ADD_DOCTOR;
        try{
            c =  DBhelper.getconnetion();
            if(c!=null){
                ps=c.prepareStatement(sql);
                ps.setString(1,doctor.getName());
                ps.setString(2,doctor.getSurname());
                ps.setString(3,doctor.getTask());
                ps.setString(4,doctor.getDepartament());
                ps.execute();
                result=true;

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Doctor getDoctorById(Long doctorId) throws Exception {
        Doctor doctor=new Doctor();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=SqlDoctor.GET_DOCTOR_BY_ID;
        try{
           c =  DBhelper.getconnetion();
           if(c!=null){
              ps = c.prepareStatement(sql);
              ps.setLong(1,doctorId);
              rs = ps.executeQuery();
              if(rs.next()){
                  doctor.setId(rs.getLong("ID"));
                  doctor.setName(rs.getString("NAME"));
                  doctor.setSurname(rs.getString("SURNAME"));
                  doctor.setTask(rs.getString("TASK"));
                  doctor.setDepartament(rs.getString("DEPARTAMENT"));

              }
           }else {
               System.out.println("Connection is null!");
           }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return doctor;
    }

    @Override
    public boolean updateDoctor(Doctor doctor, Long doctorId) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlDoctor.UPDATE_DOCTOR;
        try{
            c=DBhelper.getconnetion();

            if(c!=null){
                ps=c.prepareStatement(sql);
                ps.setString(1,doctor.getName());
                ps.setString(2,doctor.getSurname());
                ps.setString(3,doctor.getTask());
                ps.setString(4,doctor.getDepartament());
                ps.setLong(5,doctorId);
                ps.execute();
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
    public boolean deleteDoctor(Long doctorId) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlDoctor.DELETE_DOCTOR;
        try{
            c =  DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,doctorId);
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
    public List<Doctor> getDoctorComboSorenessById(Long sorenessId) throws Exception {
        List<Doctor> doctors=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=SqlDoctor.GET_DOCTOR_COMBO_SORENESS_BY_ID;
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,sorenessId);
                rs = ps.executeQuery();
                while (rs.next()){
                    Doctor doctor=new Doctor();
                    doctor.setId(rs.getLong(1));
                    doctor.setName(rs.getString(2));
                    doctor.setSurname(rs.getString(3));
                    doctors.add(doctor);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return doctors;
    }

    @Override
    public List<Doctor> searchDoctor(String keyword) throws Exception {
        List<Doctor> doctors=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ROWNUM r, ID,NAME,SURNAME,TASK,DEPARTAMENT FROM DOCTOR\n" +
                "WHERE ACTIVE=1 AND (LOWER(NAME) LIKE LOWER ('%"+keyword+"%')" +
                "OR LOWER (SURNAME) LIKE LOWER ('%"+keyword+"%')"+
                "OR LOWER (TASK) LIKE LOWER ('%"+keyword+"%')"+
                "OR LOWER (DEPARTAMENT) LIKE LOWER ('%"+keyword+"%'))";
        try{
            c = DBhelper.getconnetion();
            ps=c.prepareStatement(sql);
            if(c!=null){
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Doctor doctor=new Doctor();
                    doctor.setR(rs.getLong("r"));
                    doctor.setId(rs.getLong("ID"));
                    doctor.setName(rs.getString("NAME"));
                    doctor.setSurname(rs.getString("SURNAME"));
                    doctor.setTask(rs.getString("TASK"));
                    doctor.setDepartament(rs.getString("DEPARTAMENT"));
                    doctors.add(doctor);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return doctors;
    }
}
