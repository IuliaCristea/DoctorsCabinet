package Service;

import Classes.Appointment;
import Classes.Doctor;
import Classes.Hospital;
import Classes.Patient;
import DAO.AppointmentDAO;

import java.time.LocalDate;

public class AppointmentService
{
    private static AppointmentDAO appointments;

    public static AppointmentDAO getAppointments() {
        return appointments;
    }

    public static void setAppointments(AppointmentDAO appointments) {
        AppointmentService.appointments = appointments;
    }

    public void makeAppointment(Patient patient, Doctor doctor, Hospital hospital, LocalDate date)
    {
        Appointment app = new Appointment(patient,doctor,hospital,date);
        appointments.addAppointment(app);
    }


}
