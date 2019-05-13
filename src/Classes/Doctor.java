package Classes;

import DAO.JPAConsultationDAO;
import DAO.JPAPatientDAO;
import Log.MyLogger;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.util.Date;

public class Doctor extends Person {

    private Specialization specialization;

    public Doctor(String firstName, String lastName, String cnp, String birthDate, String gender,
                  String address, String phone, Specialization specialization2) throws ParseException {
        super(firstName, lastName, cnp, birthDate, gender,address, phone);
        specialization = specialization2;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization2) {

        specialization = specialization2;
    }

    public void makeConsultation(@NotNull String cnp_patient, Date date, String diagnosis, String observations, String recipe, PrescriptionTicket ticket)
    {
        try {
            JPAPatientDAO jpatient = new JPAPatientDAO();
            Patient p = jpatient.getById(cnp_patient);
            Consultation cons = new Consultation(date, this, p, this.specialization, diagnosis, observations, recipe, ticket);
            JPAConsultationDAO jcons = new JPAConsultationDAO();
            jcons.save(cons);
        }
        catch(Exception ex)
        {
            MyLogger.Error("make consultation doctor ",ex.toString());
        }
    }

}
