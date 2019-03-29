import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ClinicService {


    void MakeAppointment(Patient patient, Hospital hospital, Doctor doctor, String day, String month, AppointmentDAO apps)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate date = LocalDate.parse(day+"/"+month, formatter);
        Appointment app = new Appointment(patient, doctor, hospital, date);
        apps.addAppointment(app);
    }

    void RegisterNewPatient(String firstName, String lastName, String cnp, String birthDate, int age, String gender,
                            String street, int streetNumber, String building, int floor, int apRoom, PatientDAO patients)
    {
        Patient p = new Patient(firstName,lastName, cnp, birthDate,age, gender,
                street,streetNumber,  building, floor, apRoom);

        patients.addPatient(p);
    }

    //void CheckInPatient()
}
