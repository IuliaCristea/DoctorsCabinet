package Service;

import Classes.Patient;
import DAO.DoctorDAO;
import DAO.PatientDAO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static DAO.DoctorDAO.Doctors;

public class PatientService {
    private PatientDAO patientDAO;

    public void CheckInPatient(String firstName, String lastName, String cnp, String birthDate, int age, String gender,
                               String street, int streetNumber, String building, int floor, int apRoom, String doctorName, String hospitalName )
    {
        boolean flag = false;
        var patients = patientDAO.getPatients();
        for(var p : patients)
        {
            if(cnp == p.getCNP())
            {
                p.setPresent(true);
                flag = true; //found the old patient
            }
        }

        if(!flag)
        {
            Patient patient = new Patient(firstName,lastName, cnp, birthDate,age, gender,
                    street,streetNumber,  building, floor, apRoom);
            patient.setPresent(true);
        }
    }

    public void CheckOutPatient(String cnp, String doctorFirstName, String doctorLastName, String hospitalname)
    {

    }

    public void RegisterNewPatient(String firstName, String lastName, String cnp, String birthDate, int age, String gender,
                            String street, int streetNumber, String building, int floor, int apRoom, PatientDAO patients)
    {
        Patient p = new Patient(firstName,lastName, cnp, birthDate,age, gender,
                street,streetNumber,  building, floor, apRoom);

        patients.addPatient(p);
    }


}
