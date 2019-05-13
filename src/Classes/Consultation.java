package Classes;

import java.util.Date;

public class Consultation {
    private int id;
    private Date date;
    private Doctor doctor;
    private Patient patient;
    private Specialization specialization;
    private String diagnosis;
    private String observations;
    private String recipe;
    private PrescriptionTicket ticket;


    public Consultation(Date date2, Classes.Doctor doctor2, Patient patient2, Classes.Specialization specialization2, String diagnosis2, String observations2, String recipe2, PrescriptionTicket ticket2) {
        this.date = date2;
        this.doctor = doctor2;
        this.patient = patient2;
        this.specialization = specialization2;
        this.diagnosis = diagnosis2;
        this.observations = observations2;
        this.recipe = recipe2;
        this.ticket = ticket2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public PrescriptionTicket getTicket() {
        return ticket;
    }

    public void setTicket(PrescriptionTicket ticket) {
        this.ticket = ticket;
    }
}
