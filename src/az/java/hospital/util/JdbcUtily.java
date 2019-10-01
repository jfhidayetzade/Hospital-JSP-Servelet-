package az.java.hospital.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtily {

    public static void close(Connection c, PreparedStatement ps, ResultSet rs) throws SQLException {

        if(c!=null)
            c.close();
        if(ps!=null)
            ps.close();
        if(rs!=null)
            rs.close();
    }
}
