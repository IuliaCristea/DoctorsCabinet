package Classes;

import java.time.LocalDate;

public class Appointment {
    private Patient Patient;
    private Doctor Doctor;
    private Hospital hospital;
    private LocalDate Date;

    public Appointment(Patient patient, Doctor doctor, Hospital hospital, LocalDate date) {
        this.Patient = patient;
        this.Doctor = doctor;
        this.hospital = hospital;
        this.Date = date;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        Patient = patient;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor doctor) {
        Doctor = doctor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
