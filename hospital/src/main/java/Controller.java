import java.util.List;

//
//import java.util.List;
//
public class Controller {
    //
    public static boolean loginUser(String username, String password) {
        boolean userExists = UserDAO.userWithUsernameExists(username);
        if (!userExists) {
            return false;
        }
        if (userExists) {
            if (validateUserPass(password)) {
                return true;
            }
            ;
            return false;
        } else {
            return true;
        }
    }

    //
    public static boolean deletePatientFolder(int ID) {
        boolean result = false;
        boolean patientFldrExist = PatientFolderDAO.patientFolderExist(ID);
        if (patientFldrExist) {
            result = PatientFolderDAO.deletePatientFolder(ID);
        }
        return result;
    }

    //
    public static boolean openFolder(String patientID, String specialistID) {

        Patient patient = PatientDAO.getPatient(patientID);

        PatientFolder patientFolder = new PatientFolder();
        patientFolder.setPatientID(patient.getPatientID());
        patientFolder.setOncologistID(specialistID);
        return PatientFolderDAO.insertFolder(patientFolder);

    }

    //
//
    public static boolean addNewMedicine(Medicine med) {
        return MedicineDAO.insertMedicine(med);
    }

    public static List<Medicine> getMedicines() {
        return MedicineDAO.getMedicines();
    }



    public static boolean registerUser(String username, String password, String role) {
        boolean stExists = UserDAO.userWithUsernameExists(username);
        if (!stExists) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            UserDAO.insertUser(user);
        }
        if (stExists) {
            return false;
        } else {
            return true;
        }
    }

    //
//


		public static String getUserRole (String username){
			return UserDAO.getUserRole(username);
		}

//
    private static boolean validateUserPass(String password) {
        return UserDAO.checkPass(password);
    }
//	}
}