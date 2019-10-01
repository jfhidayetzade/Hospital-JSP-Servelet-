package az.java.hospital.model;

public abstract class HospitalModel {
    private long r;
    private long id;
    private int active;

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "HospitalModel{" +
                "r=" + r +
                ", id=" + id +
                ", active=" + active +
                '}';
    }
}
