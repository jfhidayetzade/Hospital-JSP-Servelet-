package az.java.hospital.util;

public class SqlSoreness {

    public static final String GET_SORENESS_LIST="SELECT ROWNUM r,  ID, NAME, SURNAME, TASK, DEPARTAMENT FROM DOCTOR\n"
            + "WHERE ACTIVE=1";

    public static final String ADD_SORENESS="INSERT INTO SORENESS (ID,DIAGONIS,MEDICINES)\n" +
            "VALUES(SORENESS_SEQ.NEXTVAL,?,?)";

    public static final String GET_SORENESS_BY_ID="SELECT  ID, DIAGONIS, MEDICINES FROM SORENESS\n"
            + "WHERE ACTIVE=1 AND ID=?";
    public static final String UPDATE_SORENESS="UPDATE SORENESS SET DIAGONIS=?, MEDICINES=?" +
            "WHERE ID=?";

    public static final String DELETE_SORENESS="UPDATE SORENESS SET ACTIVE=0\n" +
            "WHERE ID=?";
}
