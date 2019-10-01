package az.java.hospital.util;

public class SqlDoctor {

    public static final String GET_DOCTOR_LIST="SELECT ROWNUM r,  ID, NAME, SURNAME, TASK, DEPARTAMENT FROM DOCTOR\n"
            + "WHERE ACTIVE=1";

    public static final String ADD_DOCTOR="INSERT INTO DOCTOR (ID,NAME,SURNAME,TASK,DEPARTAMENT)\n" +
            "VALUES(DOCTOR_SEQ.NEXTVAL,?,?,?,?)";

    public static final String GET_DOCTOR_BY_ID="SELECT  ID, NAME, SURNAME, TASK, DEPARTAMENT FROM DOCTOR\n"
            + "WHERE ACTIVE=1 AND ID=?";
    public static final String UPDATE_DOCTOR="UPDATE DOCTOR SET NAME=?, SURNAME=?, TASK=?,DEPARTAMENT=?" +
            "WHERE ID=?";

    public static final String DELETE_DOCTOR="UPDATE DOCTOR SET ACTIVE=0\n" +
            "WHERE ID=?";

    public static final String GET_DOCTOR_COMBO_SORENESS_BY_ID="SELECT DISTINCT  D.ID,D.NAME,D.SURNAME FROM SCHEDULE SC\n" +
            "INNER JOIN SORENESS S ON  SC.S_ID=S.ID\n" +
            "INNER JOIN DOCTOR D ON SC.D_ID=D.ID\n" +
            "WHERE S.ID=?";

}
