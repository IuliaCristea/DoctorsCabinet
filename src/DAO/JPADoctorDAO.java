package DAO;

import Classes.Doctor;
import Classes.Specialization;
import DataBaseConnection.DbConnection;
import Log.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JPADoctorDAO implements IDAO<Doctor>{
    private Connection connection;
    private Doctor doctor;


    @Override
    public List<Doctor> getAll(){
        ResultSet result = null;
        String query = "SELECT * FROM clinic.doctor";
        List<Doctor> toReturn = new ArrayList<>();

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
                int spec = result.getInt(8);
                Specialization specialization = Specialization.None;
                switch(spec){
                    case 0:
                        specialization = Specialization.Pediatrics;
                        break;
                    case 1:
                        specialization = Specialization.Neurology;
                        break;
                    case 2:
                        specialization = Specialization.Cardiology;
                        break;
                    case 3:
                        specialization = Specialization.Surgery;
                        break;
                    case 4:
                        specialization = Specialization.Gastroenterology;
                        break;
                    case 5:
                        specialization = Specialization.FamilyMedicine;
                        break;
                    case 6:
                        specialization = Specialization.LaborMedicine;
                        break;
                    case 7:
                        specialization = Specialization.Ophthalmology;
                        break;
                    case 8:
                        specialization = Specialization.Psychology;
                        break;
                    case 9:
                        specialization = Specialization.Dentistry;
                        break;
                }

                Doctor toAdd = new Doctor(firstName,lastName,cnp,date,gender,address,phone,specialization);

                toReturn.add(toAdd);
            }

        }
        catch(Exception ex)
        {
            MyLogger.Error("getAll(Doctors)",ex.toString());
            return new ArrayList<>();
        }

        return toReturn;
    }


    @Override
    public Doctor getById(String id){
        String query = "select * from  clinic.doctor where cnp_doctor = '" + id+ "'";
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
            int spec = result.getInt(8);
            Specialization specialization = Specialization.None;
            switch(spec){
                case 0:
                    specialization = Specialization.Pediatrics;
                    break;
                case 1:
                    specialization = Specialization.Neurology;
                    break;
                case 2:
                    specialization = Specialization.Cardiology;
                    break;
                case 3:
                    specialization = Specialization.Surgery;
                    break;
                case 4:
                    specialization = Specialization.Gastroenterology;
                    break;
                case 5:
                    specialization = Specialization.FamilyMedicine;
                    break;
                case 6:
                    specialization = Specialization.LaborMedicine;
                    break;
                case 7:
                    specialization = Specialization.Ophthalmology;
                    break;
                case 8:
                    specialization = Specialization.Psychology;
                    break;
                case 9:
                    specialization = Specialization.Dentistry;
                    break;
            }

            Doctor doctor = new Doctor(firstName,lastName,cnp,date,gender,address,phone,specialization);
            return doctor;
        }
        catch(Exception ex)
        {
            MyLogger.Error("get doctor by id",ex.toString());
            return null;
        }
    }

    @Override
    public void save(Doctor doctor)
    {
        String query = "insert into clinic.doctor (cnp_doctor,first_name,last_name,birth_date,gender,address,phone, specialization) values (?,?,?,?,?,?,?,?)";
        try{
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,doctor.getCNP());
            statement.setString(2,doctor.getFirstName());
            statement.setString(3,doctor.getLastName());
            statement.setString(4,doctor.getDateOfBirth().toString());
            statement.setString(5,doctor.getGender());
            statement.setString(6,doctor.getAddress());
            statement.setString(7,doctor.getPhone());
            statement.setInt(8,doctor.getSpecialization().getValue());

            statement.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("save doctor",ex.toString());
        }
    }

    @Override
    public void delete(Doctor doctor)
    {
        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement st = connection.prepareStatement("DELETE FROM clinic.doctor WHERE cnp_doctor = ?");
            st.setString(1, doctor.getCNP());
            st.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("Delete doctor",ex.toString());
        }
    }

    @Override
    public void update(Doctor doctor)
    {
        String query = "Update clinic.doctor set first_name = ?,last_name = ?,birth_date = ?,gender = ?,address = ?,phone = ?, specialization = ? where cnp_doctor = ?";
        try{
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,doctor.getFirstName());
            statement.setString(2,doctor.getLastName());
            statement.setString(3,doctor.getDateOfBirth().toString());
            statement.setString(4,doctor.getGender());
            statement.setString(5,doctor.getAddress());
            statement.setString(6,doctor.getPhone());
            statement.setString(7,doctor.getCNP());
            statement.setInt(8,doctor.getSpecialization().getValue());
            statement.executeUpdate();


        }
        catch(Exception ex){
            MyLogger.Error("Update doctor",ex.toString());
        }
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization){
        try {
            Specialization spec = Specialization.None;
                switch (specialization) {
                    case "pediatrics":
                        spec = Specialization.Pediatrics;
                        break;
                    case "neurology":
                        spec = Specialization.Neurology;
                        break;
                    case "Cardiology":
                        spec = Specialization.Cardiology;
                        break;
                    case "surgery":
                        spec = Specialization.Surgery;
                        break;
                    case "gastroenterology":
                        spec = Specialization.Gastroenterology;
                        break;
                    case "family medicine":
                        spec = Specialization.FamilyMedicine;
                        break;
                    case "labor medicine":
                        spec = Specialization.LaborMedicine;
                        break;
                    case "ophthalmology":
                        spec = Specialization.Ophthalmology;
                        break;
                    case "psychology":
                        spec = Specialization.Psychology;
                        break;
                    case "dentistry":
                        spec = Specialization.Dentistry;
                        break;
                    default:
                        System.out.println("Invalid input! Try again.");
                        throw new IllegalStateException("Unexpected value: " + specialization);
                }
            String query = "select * from  clinic.doctor where specialization = '" + spec.getValue()+ "'";
            ResultSet result = null;
            List<Doctor> doctors = new ArrayList<>();
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);

            while(result.next()) {
                String cnp = result.getString("cnp_doctor");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String date = result.getString("birth_date");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String phone = result.getString("phone");

                Doctor doctor = new Doctor(firstName, lastName, cnp, date, gender, address, phone, spec);
                doctors.add(doctor);
                result.next();
            }
            return doctors;
        }
        catch(Exception ex)
        {
            MyLogger.Error("get doctor by id",ex.toString());
            return null;
        }
    }


}
