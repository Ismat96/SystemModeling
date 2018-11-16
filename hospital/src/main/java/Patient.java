import java.util.Date;

public class Patient {
    private String patientID;
    private String name;
    private String surname;
    private String date;
    private String insuranceCOde;

    public String getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public String getInsuranceCOde() {
        return insuranceCOde;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInsuranceCOde(String insuranceCOde) {
        this.insuranceCOde = insuranceCOde;
    }
}
