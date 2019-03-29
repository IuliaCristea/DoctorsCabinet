
import java.time.LocalDate;
import java.util.Set;

public class Consultation {
    private LocalDate Date;
    private Doctor Doctor;
    private Specialization Specialization;
    private String Diagnosis;
    private Set<String> Observations;
    private String Recipe;
    private PrescriptionTicket Ticket;

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor doctor) {
        Doctor = doctor;
    }

    public Specialization getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(Specialization specialization) {
        Specialization = specialization;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public Set<String> getObservations() {
        return Observations;
    }

    public void setObservations(Set<String> observations) {
        Observations = observations;
    }

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public PrescriptionTicket getTicket() {
        return Ticket;
    }

    public void setTicket(PrescriptionTicket ticket) {
        Ticket = ticket;
    }
}
