public class Patient {
    private String patientID;
    private String name;
    private String surname;
    private String date;
    private String insuranceCode;

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

    public String getInsuranceCode() {
        return insuranceCode;
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

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }
}
