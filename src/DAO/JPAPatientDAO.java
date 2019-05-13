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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JPAPatientDAO implements IDAO<Patient> {

    private Connection connection;
    private Patient patient;

    @Override
    public List<Patient> getAll()
    {
        ResultSet result = null;
        String query = "SELECT * FROM clinic.patient";
        List<Patient> toReturn = new ArrayList<>();

        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {

                String cnp = result.getString(1);
                String lastName = result.getString(2);
                String firstName = result.getString(3);
                String date = result.getString(4);
                String gender = result.getString(5);
                String address = result.getString(6);
                String phone = result.getString(7);
                Patient toAdd = new Patient(firstName,lastName,cnp,date,gender,address,phone);

                toReturn.add(toAdd);

            }

        }
        catch(Exception ex)
        {
            MyLogger.Error("getAll(Patients)",ex.toString());
            return new ArrayList<>();
        }

        return toReturn;
    }

    @Override
    public Patient getById(String id){
        String query = "select * from  clinic.patient where cnp_patient = '" + id+ "'";
        ResultSet result = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(!result.next())
            {
                return null;
            }
            String cnp = result.getString(1);
            String lastName = result.getString(2);
            String firstName = result.getString(3);
            String date = result.getString(4);
            String gender = result.getString(5);
            String address = result.getString(6);
            String phone = result.getString(7);

            Patient patient = new Patient(firstName,lastName,cnp,date,gender,address,phone);
            return patient;
        }
        catch(Exception ex)
        {
            MyLogger.Error("get patient by id",ex.toString());
            return null;
        }

    }

    @Override
    public void save(Patient patient) {
        String query = "insert into clinic.patient (cnp_patient,first_name,last_name,birth_date,gender,address,phone) values (?,?,?,?,?,?,?)";
        try{
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,patient.getCNP());
            statement.setString(2,patient.getFirstName());
            statement.setString(3,patient.getLastName());
            statement.setString(4,patient.getDateOfBirth().toString());
            statement.setString(5,patient.getGender());
            statement.setString(6,patient.getAddress());
            statement.setString(7,patient.getPhone());

            statement.executeUpdate();


        }
        catch(Exception ex){
            MyLogger.Error("save patient",ex.toString());
        }
    }

    @Override
    public void delete(Patient patient) {
        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement st = connection.prepareStatement("DELETE FROM clinic.patient WHERE cnp_patient = ?");
            st.setString(1, patient.getCNP());
            st.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("Delete patient",ex.toString());
        }
    }

    @Override
    public void update(Patient patient)
    {
        String query = "Update clinic.patient set first_name = ?,last_name = ?,birth_date = ?,gender = ?,address = ?,phone = ? where cnp_patient = ?";
        try{
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,patient.getFirstName());
            statement.setString(2,patient.getLastName());
            statement.setString(3,patient.getDateOfBirth().toString());
            statement.setString(4,patient.getGender());
            statement.setString(5,patient.getAddress());
            statement.setString(6,patient.getPhone());
            statement.setString(7,patient.getCNP());
            statement.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("Update patient",ex.toString());
        }
    }

    public void makeAppointment(Patient patient, Doctor doctor, Date date)
    {
        try{
            JPAAppointmentDAO japp = new JPAAppointmentDAO();
            Appointment app = new Appointment(patient,doctor,date);
            japp.save(app);
        }
        catch(Exception ex)
        {
            MyLogger.Error("makeAppointment ",ex.toString());
        }
    }


}
