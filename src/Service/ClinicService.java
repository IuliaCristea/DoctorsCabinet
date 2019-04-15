package Service;

import Classes.Appointment;
import Classes.Doctor;
import Classes.Hospital;
import Classes.Patient;
import DAO.AppointmentDAO;
import DAO.PatientDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClinicService {

    void MakeAppointment(Patient patient, Hospital hospital, Doctor doctor, String day, String month, AppointmentDAO apps)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate date = LocalDate.parse(day+"/"+month, formatter);
        Appointment app = new Appointment(patient, doctor, hospital, date);
        apps.addAppointment(app);
    }

}
