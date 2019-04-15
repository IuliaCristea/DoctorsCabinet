package Service;

import Classes.Appointment;
import Classes.Doctor;
import Classes.Hospital;
import Classes.Patient;
import DAO.AppointmentDAO;

import java.time.LocalDate;

public class AppointmentService
{
    public void makeAppointment(Patient patient, Doctor doctor, Hospital hospital, LocalDate date, AppointmentDAO appointments)
    {
        Appointment app = new Appointment(patient,doctor,hospital,date);
        appointments.addAppointment(app);
    }

}
