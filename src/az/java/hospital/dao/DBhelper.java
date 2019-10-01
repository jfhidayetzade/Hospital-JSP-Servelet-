package az.java.hospital.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBhelper {

    public static Connection getconnetion () throws Exception {

        Context context=new InitialContext();
        DataSource dataSource= (DataSource) context.lookup("java:comp/env/jdbc/HOSPITAL");
        Connection c = dataSource.getConnection();


        return  c;
    }

   /* public static void main(String[] args) throws Exception {
        Connection c=DBhelper.getconnetion();
        if(c!=null){
            System.out.println(c);
        }
    }*/

}
