package az.java.hospital.dao.imple;

import az.java.hospital.dao.DBhelper;
import az.java.hospital.dao.PaymentDao;
import az.java.hospital.model.Doctor;
import az.java.hospital.model.Patient;
import az.java.hospital.model.Payment;
import az.java.hospital.model.Soreness;
import az.java.hospital.util.JdbcUtily;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImple implements PaymentDao {
    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> payments = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, PY.ID, P.ID P_ID, P.NAME, P.SURNAME, D.ID D_ID, D.NAME D_NAME, D.SURNAME D_SURNAME, S.ID S_ID, S.DIAGONIS, PAYMENT_DATE , S.MEDICINES, AMOUNT FROM PAYMENTT PY\n" +
                "INNER JOIN PATIENT P ON PY.P_ID=P.ID\n" +
                "INNER JOIN DOCTOR D ON PY.D_ID=D.ID\n" +
                "INNER JOIN SORENESS S ON PY.S_ID=S.ID\n" +
                "WHERE PY.ACTIVE=1 AND P.ACTIVE=1 AND D.ACTIVE=1 AND S.ACTIVE=1";
        try {
            c = DBhelper.getconnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setR(rs.getLong("R"));
                    payment.setId(rs.getLong("ID"));
                    Patient patient = new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    Soreness soreness = new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    payment.setDate(rs.getDate("PAYMENT_DATE"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    payment.setAmount(rs.getLong("AMOUNT"));
                    payment.setPatient(patient);
                    payment.setDoctor(doctor);
                    payment.setSoreness(soreness);
                    payments.add(payment);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtily.close(c, ps, rs);
        }
        return payments;
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PAYMENTT (ID, P_ID, S_ID, D_ID,AMOUNT, PAYMENT_DATE )\n"
                + "VALUES(PAYMENTT_SEQ.NEXTVAL, ?,?,?,?,?)";
        try {
            c = DBhelper.getconnetion();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, payment.getPatient().getId());
                ps.setLong(2, payment.getSoreness().getId());
                ps.setLong(3, payment.getDoctor().getId());
                ps.setLong(4, payment.getAmount());
                ps.setDate(5, new java.sql.Date(payment.getDate().getTime()));
                ps.execute();
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtily.close(c, ps, null);
        }
        return result;
    }

    @Override
    public Payment getPaymentById(Long paymentId) throws Exception {
        return null;
    }

    @Override
    public boolean updatePayment(Payment payment, Long paymentId) throws Exception {
        return false;
    }

    @Override
    public boolean deletePayment(Long paymentId) throws Exception {
        return false;
    }

    @Override
    public List<Payment> seacrhPaymentData(String keyword) throws Exception {
        return null;
    }
}
