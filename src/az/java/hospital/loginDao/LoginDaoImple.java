package az.java.hospital.loginDao;

import az.java.hospital.dao.DBhelper;
import az.java.hospital.model.Login;
import az.java.hospital.model.Role;
import az.java.hospital.util.JdbcUtily;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImple implements LoginDao {
    @Override
    public Login login(String username, String password) throws Exception {
        Login login =new Login();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT L.ID,L.USERNAME,L.PASSWORD,L.NAME,L.SURNAME, R.ROLE_NAME FROM LOGINN L\n" +
                "INNER JOIN ROLE R ON L.ROLE_ID=R.ID\n" +
                "WHERE L.ACTIVE=1 AND R.ACTIVE=1 AND L.USERNAME=? AND L.PASSWORD=?";
        try{
            c = DBhelper.getconnetion();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if(rs.next()){
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                    Role role = new Role();
                    role.setRoleName(rs.getString("ROLE_NAME"));
                    login.setRole(role);
                }else {
                    login=null;
                }
            }else {
                System.out.println("Connection is null!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtily.close(c,ps,rs);
        }
        return login;
    }
}
