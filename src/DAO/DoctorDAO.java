package DAO;

import Classes.Consultation;
import Classes.Doctor;
import Classes.Patient;
import Classes.PrescriptionTicket;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

public class DoctorDAO {
    private static Set<Doctor> Doctors;

    public Set<Doctor> getDoctors()
    {
        return Doctors;
    }

    public void addDoctor(Doctor doctor)
    {
        Doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor)
    {
        Iterator<Doctor> iterator = Doctors.iterator();
        iterator.hasNext();
        {
            Doctor d = iterator.next();
            if (d == doctor)
            {
                iterator.remove();
            }
        }
    }

    public void editDoctor(Doctor doctor)
    {
        Iterator<Doctor> iterator = Doctors.iterator();
        iterator.hasNext();
        {
            Doctor d = iterator.next();
            if (d.getCNP() == doctor.getCNP())
            {
                d=doctor;
            }
        }
    }

    public void addToQueue(Doctor doctor, Patient patient)
    {
        doctor.getWaitingQueue().add(patient);
    }

    public void removeFromQueue(Doctor doctor)
    {
        doctor.getWaitingQueue().poll();
    }

    public Consultation makeConsultation(Doctor doctor, LocalDate date, String diagnosis, Set<String>observations, String recipe, PrescriptionTicket ticket)
    {
        Consultation consultation = doctor.makeConsultation(date,diagnosis,observations,recipe,ticket);
        consultation.setDoctor(doctor);
        consultation.setSpecialization(doctor.getSpecialization());
        return consultation;
    }
}
