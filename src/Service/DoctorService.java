package Service;

import Classes.Consultation;
import Classes.Doctor;
import Classes.PrescriptionTicket;
import DAO.DoctorDAO;

import java.time.LocalDate;
import java.util.Set;

public class DoctorService {

    private static DoctorDAO doctorDAO;

    public static DoctorDAO getDoctorDAO() {
        return doctorDAO;
    }

    public static void setDoctorDAO(DoctorDAO doctorDAO) {
        DoctorService.doctorDAO = doctorDAO;
    }

    public Consultation makeConsultation(Doctor doctor, LocalDate date, String diagnosis, Set<String> observations, String recipe, PrescriptionTicket ticket)
    {
        Consultation consultation = doctorDAO.makeConsultation(doctor,date,diagnosis,observations,recipe,ticket);
        return consultation;
    }



}
