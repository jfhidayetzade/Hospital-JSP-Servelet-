package az.java.hospital.util;

public class SqlTreatments {

    public static final String GET_TREATMENT_LIST="SELECT ROWNUM r, SC.ID SC_ID,P.ID P_ID,P.NAME P_NAME , P.SURNAME P_SURNAME,D.ID D_ID,D.NAME D_NAME,D.SURNAME D_SURNAME,S.ID S_ID,S.DIAGONIS,S.MEDICINES FROM SCHEDULE SC\n" +
            "INNER JOIN PATIENT P ON SC.P_ID=P.ID\n" +
            "INNER JOIN DOCTOR D ON SC.D_ID=D.ID\n" +
            "INNER JOIN SORENESS S ON SC.S_ID=S.ID\n" +
            "WHERE SC.ACTIVE=1 AND P.ACTIVE=1 AND D.ACTIVE=1 AND S.ACTIVE=1";
    public static final String ADD_TREATMENT="INSERT INTO SCHEDULE(ID,P_ID,D_ID,S_ID)\n" +
            "VALUES(SCHEDULE_SEQ.NEXTVAL,?,?,?)";
    public static final String GET_TREATMENT_BY_ID="SELECT ID, P_ID,D_ID, S_ID FROM SCHEDULE\n" +
            "WHERE ACTIVE=1 AND ID=?";
    public static final String UPDATE_TREATMENT="UPDATE SCHEDULE SET P_ID=?, D_ID=?, S_ID=?\n" +
            "WHERE ID=?";
    public static final String DELETE_TREATMENT="UPDATE SCHEDULE SET ACTIVE=0\n" +
            "WHERE ID=?";
}
