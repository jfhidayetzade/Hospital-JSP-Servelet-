package az.java.hospital.model;

public class Treatment extends HospitalModel{
    private Patient patient;
    private Doctor doctor;
    private Soreness soreness;


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

    @Override
    public String toString() {
        return "Treatment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", soreness=" + soreness +
                '}';
    }
}
