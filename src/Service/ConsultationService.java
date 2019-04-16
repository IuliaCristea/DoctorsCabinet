package Service;

import Classes.Consultation;
import Classes.Doctor;
import Classes.Patient;
import DAO.ConsultationDAO;
import kotlin.Pair;

import java.time.LocalDate;

public class ConsultationService {

    private static ConsultationDAO consultationDAO;

    public void addConsultation(Doctor doctor, Consultation consultation, Patient patient)
    {
        consultationDAO.getConsultations().put(new Pair(LocalDate.now(),patient),consultation);
    }

    public Consultation getConsultationByPatient(Patient patient)
    {
        return consultationDAO.getConsultations().get(patient);
    }
}
