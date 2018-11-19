public class PatientFolder {
    private int ID;
    private String patientID;
    private String oncologistID;
    private String firstVisitDate;

    public String getFirstVisitDate() {
        return firstVisitDate;
    }

    public void setFirstVisitDate(String firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }



    public int getID() {
        return ID;
    }

    public String getOncologistID() {
        return oncologistID;
    }

    public void setOncologistID(String oncologistID) {
        this.oncologistID = oncologistID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }


}
