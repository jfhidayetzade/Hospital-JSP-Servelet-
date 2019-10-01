package az.java.hospital.model;

public class AdvanceSearch {
    private Long sorenessId;
    private Long doctorId;
    private String beginDate;
    private String endDate;

    public Long getSorenessId() {
        return sorenessId;
    }

    public void setSorenessId(Long sorenessId) {
        this.sorenessId = sorenessId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "AdvanceSearch{" +
                "sorenessId=" + sorenessId +
                ", doctorId=" + doctorId +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
