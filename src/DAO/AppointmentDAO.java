package DAO;

import Classes.Appointment;
import Classes.Doctor;
import Classes.Hospital;
import Classes.Patient;

import java.time.LocalDate;
import java.util.Set;

public class AppointmentDAO
{
    private static Set<Appointment> Appointments;

    public void addAppointment(Appointment app)
    {

        Appointments.add(app);
    }

}
