package az.java.hospital.model;

import java.util.Date;

public class Payment extends HospitalModel{

    private Patient patient;
    private Doctor doctor;
    private Soreness soreness;
    private Date date;
    private long amount;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Soreness getSoreness() {
        return soreness;
    }

    public void setSoreness(Soreness soreness) {
        this.soreness = soreness;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", soreness=" + soreness +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
