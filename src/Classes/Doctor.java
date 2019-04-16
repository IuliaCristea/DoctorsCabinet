package Classes;

import java.time.LocalDate;
import java.util.Queue;
import java.util.Set;

public class Doctor extends Person {

    private Specialization Specialization;
    private Queue<Patient> WaitingQueue;

    public Doctor(String firstName, String lastName, String cnp, String birthDate, int age, String gender,
                  String street, int streetNumber, String building, int floor, int apRoom)
    {
        super(firstName, lastName, cnp, birthDate, age, gender, street, streetNumber, building, floor, apRoom);
    }

    public Specialization getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(Specialization specialization) {

        Specialization = specialization;
    }

    public Queue<Patient> getWaitingQueue()
    {
        return WaitingQueue;
    }

    public Consultation makeConsultation(LocalDate date, String diagnosis, Set<String>observations, String recipe,PrescriptionTicket ticket)
    {
        Consultation consultation = new Consultation();
        consultation.setDate(date);
        consultation.setDiagnosis(diagnosis);
        consultation.setObservations(observations);
        consultation.setRecipe(recipe);
        consultation.setTicket(ticket);
        return consultation;
    }

}
