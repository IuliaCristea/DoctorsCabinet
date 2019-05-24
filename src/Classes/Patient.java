package Classes;

import DAO.JPAAppointmentDAO;
import DAO.JPAPatientDAO;
import Log.MyLogger;

import java.text.ParseException;
import java.util.Date;

public class Patient extends Person {

    private JPAPatientDAO jpaPatientDAO = new JPAPatientDAO();


    public Patient(String firstName, String lastName, String cnp, String birthDate, String gender,
                   String address, String phone) throws ParseException {
        super(firstName,lastName, cnp, birthDate, gender,
            address,phone);

    }

    public void registerNewPatient()
    {
        try {
            jpaPatientDAO.save(this);
        }
        catch(Exception ex)
        {
            MyLogger.Error("Register new patient ", ex.toString());
        }
    }

    public void makeAppointment(Doctor doctor, Date date)
    {
        try{
            Patient p = jpaPatientDAO.getById(this.getCNP());
            JPAAppointmentDAO japp = new JPAAppointmentDAO();
            Appointment app = new Appointment(p,doctor,date);
            japp.save(app);
        }
        catch(Exception ex)
        {
            MyLogger.Error("makeAppointment ",ex.toString());
        }
    }

}


