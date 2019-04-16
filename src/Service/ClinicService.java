package Service;

import Classes.*;
import DAO.AppointmentDAO;
import DAO.DoctorDAO;
import DAO.PatientDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClinicService {

    private static PatientService patientService;
    private static AppointmentService appointmentService;
    private static DoctorService doctorService;
    private static ConsultationService consultationService;

    void MakeAppointment(Patient patient, Hospital hospital, Doctor doctor, String day, String month)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate date = LocalDate.parse(day+"/"+month, formatter);
        appointmentService.makeAppointment(patient,doctor,hospital,date);
    }

    public void CkeckOutPatient(Patient patient)
    {
        Consultation consultation = consultationService.getConsultationByPatient(patient);


    }

}
