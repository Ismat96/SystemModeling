public class PatientFolder {
    private int ID;
    private String patientID;
    private String visitID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setVisitID(String visitID) {
        this.visitID = visitID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getVisitID() {
        return visitID;
    }
}
