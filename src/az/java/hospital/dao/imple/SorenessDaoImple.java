package az.java.hospital.dao.imple;

import az.java.hospital.dao.DBhelper;
import az.java.hospital.dao.SorenessDao;
import az.java.hospital.model.Patient;
import az.java.hospital.model.Soreness;
import az.java.hospital.util.JdbcUtily;
import az.java.hospital.util.SqlSoreness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SorenessDaoImple implements SorenessDao {
    @Override
    public List<Soreness> sorenessList() throws Exception {
        List<Soreness> sorenessList=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ROWNUM r, ID,DIAGONIS,MEDICINES FROM SORENESS\n" +
                "WHERE ACTIVE=1";
        try {
            c= DBhelper.getconnetion();
            if(c!=null){
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){
                    Soreness soreness=new Soreness();
                    soreness.setR(rs.getLong("r"));
                    soreness.setId(rs.getLong("ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    sorenessList.add(soreness);
                }
            }else{
                System.out.println("Connection is null!");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {

        }
        return sorenessList;
    }

    @Override
    public boolean addSoreness(Soreness soreness) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql= SqlSoreness.ADD_SORENESS;
        try{
            c =  DBhelper.getconnetion();
            if(c!=null){
                ps=c.prepareStatement(sql);
                ps.setString(1,soreness.getDiagonis());
                ps.setString(2,soreness.getMedicines());
                ps.execute();
                result=true;

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Soreness getSorenessById(Long sorenessId) throws Exception {
        Soreness soreness=new Soreness();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=SqlSoreness.GET_SORENESS_BY_ID;
        try{
            c =  DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,sorenessId);
                rs = ps.executeQuery();
                if(rs.next()){
                    soreness.setId(rs.getLong("ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));


                }
            }else {
                System.out.println("Connection is null!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return soreness;
    }

    @Override
    public boolean updateSoreness(Soreness soreness, Long sorenessId) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlSoreness.UPDATE_SORENESS;
        try{
            c=DBhelper.getconnetion();

            if(c!=null){
                ps=c.prepareStatement(sql);
                ps.setString(1,soreness.getDiagonis());
                ps.setString(2,soreness.getMedicines());
                ps.setLong(3,sorenessId);
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
    public boolean deleteSoreness(Long sorenessId) throws Exception {
        boolean result=false;
        Connection c=null;
        PreparedStatement ps=null;
        String sql=SqlSoreness.DELETE_SORENESS;
        try{
            c =  DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,sorenessId);
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
    public List<Soreness> searchSoreness(String keyword) throws Exception {
        List<Soreness> sorenessList=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ROWNUM r, ID,DIAGONIS,MEDICINES FROM SORENESS\n" +
                "WHERE ACTIVE=1 AND (LOWER(DIAGONIS) LIKE LOWER ('%"+keyword+"%')" +
                "OR LOWER (MEDICINES) LIKE LOWER ('%"+keyword+"%'))";
        try{
            c = DBhelper.getconnetion();
            ps=c.prepareStatement(sql);
            if(c!=null){
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Soreness soreness=new Soreness();
                    soreness.setR(rs.getLong("r"));
                    soreness.setId(rs.getLong("ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    sorenessList.add(soreness);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return sorenessList;
    }
}
