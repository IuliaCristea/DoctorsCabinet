package DAO;

import Classes.Consultation;
import Classes.Doctor;
import Classes.Patient;
import kotlin.Pair;

import java.time.LocalDate;
import java.util.Dictionary;

public class ConsultationDAO {
    private static Dictionary<Pair<LocalDate, Patient>, Consultation> Consultations;

    public static Dictionary<Pair<LocalDate, Patient>, Consultation> getConsultations() {
        return Consultations;
    }

    public static void setConsultations(Dictionary<Pair<LocalDate, Patient>, Consultation> consultations) {
        Consultations = consultations;
    }

    public void addConsultation(Doctor doctor, Consultation consultation, Patient patient)
    {
        Consultations.put(new Pair(LocalDate.now(),patient),consultation);
    }

}
