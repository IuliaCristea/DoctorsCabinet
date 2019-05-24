package DAO;

import Classes.Appointment;
import Classes.Doctor;
import Classes.Patient;
import DataBaseConnection.DbConnection;
import Log.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class JPAAppointmentDAO implements IDAO<Appointment>
{
    private Connection connection;

    @Override
    public Set<Appointment> getAll()
    {
        ResultSet result = null;
        String query = "SELECT * FROM clinic.appointment";
        Set<Appointment> toReturn = new HashSet<>();

        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                String app_id = result.getString(1);
                String cnp_patient = result.getString(2);
                String cnp_doctor = result.getString(3);
                Date app_date = result.getDate(4);

                JPAPatientDAO jpatient = new JPAPatientDAO();
                Patient patient = jpatient.getById(cnp_patient);
                JPADoctorDAO jdoctor = new JPADoctorDAO();
                Doctor doctor = jdoctor.getById(cnp_doctor);
                Appointment toAdd = new Appointment(patient,doctor,app_date);

                toReturn.add(toAdd);

            }

        }
        catch(Exception ex)
        {
            MyLogger.Error("getAll(Appointments)",ex.toString());
            return new HashSet<>();
        }

        return toReturn;
    }

    @Override
    public Appointment getById(String id){
        String query = "select * from  clinic.appointment where app_id = '" + id+ "'";
        ResultSet result = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(!result.next())
            {
                return null;
            }
            String app_id = result.getString(1);
            String cnp_patient = result.getString(2);
            String cnp_doctor = result.getString(3);
            Date app_date = result.getDate(4);

            JPAPatientDAO jpatient = new JPAPatientDAO();
            Patient patient = jpatient.getById(cnp_patient);
            JPADoctorDAO jdoctor = new JPADoctorDAO();
            Doctor doctor = jdoctor.getById(cnp_doctor);
            Appointment toAdd = new Appointment(patient,doctor,app_date);

            return toAdd;
        }
        catch(Exception ex)
        {
            MyLogger.Error("get appointment by id",ex.toString());
            return null;
        }

    }

    @Override
    public void save(Appointment appointment) {
        String query = "insert into clinic.appointment (cnp_patient,cnp_doctor,app_date) values (?,?,?)";
        try{
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,appointment.getPatient().getCNP());
            statement.setString(2,appointment.getDoctor().getCNP());

            java.sql.Date sqlDate = new java.sql.Date(appointment.getDate().getTime());
            statement.setDate(3,sqlDate);
            statement.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("save appointment",ex.toString());
        }
    }

    @Override
    public void delete(Appointment appointment) {
        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement st = connection.prepareStatement("DELETE FROM clinic.appointment WHERE app_id = ?");
            st.setInt(1, appointment.getId());
            st.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("Delete patient",ex.toString());
        }
    }

    @Override
    public void update(Appointment appointment)
    {

    }

    public List<Appointment> getAppointmentsByPatient(String cnp_patient)
    {
        String query = "select * from  clinic.appointment where cnp_patient = '" + cnp_patient+ "'";
        ResultSet result = null;
        List<Appointment> toReturn = new ArrayList<>();
        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                String app_id = result.getString(1);
                String cnp_doctor = result.getString(3);
                Date app_date = result.getDate(4);

                JPAPatientDAO jpatient = new JPAPatientDAO();
                Patient patient = jpatient.getById(cnp_patient);
                JPADoctorDAO jdoctor = new JPADoctorDAO();
                Doctor doctor = jdoctor.getById(cnp_doctor);
                Appointment toAdd = new Appointment(patient, doctor, app_date);
                toReturn.add(toAdd);
            }
            return toReturn;
        }
        catch(Exception ex)
        {
            MyLogger.Error("get appointment by patient",ex.toString());
            return null;
        }
    }

    public List<Appointment> getAppointmentsByDoctor(String cnp_doctor)
    {
        String query = "select * from  clinic.appointment where cnp_doctor = '" + cnp_doctor+ "'";
        ResultSet result = null;
        List<Appointment> toReturn = new ArrayList<>();
        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                String app_id = result.getString(1);
                String cnp_p = result.getString(2);
                Date app_date = result.getDate(4);

                JPAPatientDAO jpatient = new JPAPatientDAO();
                Patient patient = jpatient.getById(cnp_p);
                JPADoctorDAO jdoctor = new JPADoctorDAO();
                Doctor doctor = jdoctor.getById(cnp_doctor);
                Appointment toAdd = new Appointment(patient, doctor, app_date);
                toReturn.add(toAdd);
            }
            return toReturn;
        }
        catch(Exception ex)
        {
            MyLogger.Error("get appointment by doctor",ex.toString());
            return null;
        }
    }

}
