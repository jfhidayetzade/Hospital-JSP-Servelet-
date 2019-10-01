package az.java.hospital.util;

public class SqlConstans {

    public static final String GET_PATIENT_LIST="SELECT ROWNUM r, ID,NAME,SURNAME,GENDER,DOB,EMAIL_ADRESS,ADDRESS FROM HOSPITAL.PATIENT\n" +
            "WHERE ACTIVE=1";

    public static final String ADD_PATIENT="INSERT INTO PATIENT (ID,NAME,SURNAME,GENDER,DOB,EMAIL_ADRESS,ADDRESS)\n" +
            "VALUES(PATIENT_SEQ.NEXTVAL,?,?,?,?,?,?)";

    public static final String GET_PATIENT_BY_ID="SELECT ID,NAME,SURNAME,GENDER,DOB,EMAIL_ADRESS,ADDRESS FROM PATIENT\n" +
            "WHERE ACTIVE=1 AND ID=?";

//    public static final String UPDATE_PATIENT=;

    public static final String DELETE_PATIENT="UPDATE PATIENT SET ACTIVE=0\n" +
            "WHERE ID=?";




}
