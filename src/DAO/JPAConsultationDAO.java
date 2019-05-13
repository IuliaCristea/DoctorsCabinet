package DAO;

import Classes.*;
import DataBaseConnection.DbConnection;
import Log.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JPAConsultationDAO implements IDAO<Consultation> {
    private Connection connection;

    @Override
    public List<Consultation> getAll()
    {
        ResultSet result = null;
        String query = "SELECT * FROM clinic.consultation";
        List<Consultation> toReturn = new ArrayList<>();

        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                String cons_id = result.getString(1);
                String cnp_doctor = result.getString(2);
                String cnp_patient = result.getString(3);
                String specialization = result.getString(4);
                String diagnosis = result.getString(5);
                String obs = result.getString(6);
                String recipe = result.getString(7);
                String ticket = result.getString(8);
                Date app_date = result.getDate(9);

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
                    }

                PrescriptionTicket pt = PrescriptionTicket.None;
                switch(ticket){
                    case "MedicalTests":
                        pt = PrescriptionTicket.MedicalTests;
                        break;
                    case "XRays":
                        pt =PrescriptionTicket.XRays;
                        break;
                    }

                JPAPatientDAO jpatient = new JPAPatientDAO();
                Patient patient = jpatient.getById(cnp_patient);
                JPADoctorDAO jdoctor = new JPADoctorDAO();
                Doctor doctor = jdoctor.getById(cnp_doctor);
                Consultation toAdd = new Consultation(app_date,doctor,patient,spec,diagnosis,obs, recipe,pt);

                toReturn.add(toAdd);

            }

        }
        catch(Exception ex)
        {
            MyLogger.Error("getAll(Consultations) ",ex.toString());
            return new ArrayList<>();
        }

        return toReturn;
    }

    @Override
    public Consultation getById(String id){
        String query = "select * from  clinic.consultation where app_id = '" + id+ "'";
        ResultSet result = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(!result.next())
            {
                return null;
            }
            String cons_id = result.getString(1);
            String cnp_doctor = result.getString(2);
            String cnp_patient = result.getString(3);
            String specialization = result.getString(4);
            String diagnosis = result.getString(5);
            String obs = result.getString(6);
            String recipe = result.getString(7);
            String ticket = result.getString(8);
            Date app_date = result.getDate(9);

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
            }

            PrescriptionTicket pt = PrescriptionTicket.None;
            switch(ticket){
                case "MedicalTests":
                    pt = PrescriptionTicket.MedicalTests;
                    break;
                case "XRays":
                    pt =PrescriptionTicket.XRays;
                    break;
            }

            JPAPatientDAO jpatient = new JPAPatientDAO();
            Patient patient = jpatient.getById(cnp_patient);
            JPADoctorDAO jdoctor = new JPADoctorDAO();
            Doctor doctor = jdoctor.getById(cnp_doctor);
            Consultation cons = new Consultation(app_date,doctor,patient,spec,diagnosis,obs, recipe,pt);

            return cons;

        }
        catch(Exception ex)
        {
            MyLogger.Error("get appointment by id",ex.toString());
            return null;
        }

    }

    @Override
    public void save(Consultation consultation) {
        String query = "insert into clinic.consultation (cnp_doctor,cnp_patient,specialization,diagnosis,observations,recipe,ticket,consult_date) values (?,?,?,?,?,?,?,?)";
        try{
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(2,consultation.getDoctor().getCNP());
            statement.setString(3,consultation.getPatient().getCNP());
            statement.setString(4,consultation.getSpecialization().toString());
            statement.setString(5,consultation.getDiagnosis());
            statement.setString(6,consultation.getObservations());
            statement.setString(7,consultation.getRecipe());
            statement.setString(8,consultation.getTicket().toString());
            java.sql.Date sqlDate = new java.sql.Date(consultation.getDate().getTime());
            statement.setDate(9,sqlDate);

            statement.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("save consultation",ex.toString());
        }
    }

    @Override
    public void delete(Consultation consultation) {
        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement st = connection.prepareStatement("DELETE FROM clinic.consultation WHERE cons_id = ?");
            st.setInt(1, consultation.getId());
            st.executeUpdate();
        }
        catch(Exception ex){
            MyLogger.Error("Delete consultation",ex.toString());
        }
    }

    @Override
    public void update(Consultation consultation)
    {

    }

    public List<Consultation> getConsultationsByPatient(String cnp_patient)
    {
        String query = "select * from  clinic.consultation where cnp_patient = '" + cnp_patient+ "'";
        ResultSet result = null;
        List<Consultation> toReturn = new ArrayList<>();
        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                String cons_id = result.getString(1);
                String cnp_doctor = result.getString(2);
                String specialization = result.getString(4);
                String diagnosis = result.getString(5);
                String obs = result.getString(6);
                String recipe = result.getString(7);
                String ticket = result.getString(8);
                Date app_date = result.getDate(9);

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
                }

                PrescriptionTicket pt = PrescriptionTicket.None;
                switch (ticket) {
                    case "MedicalTests":
                        pt = PrescriptionTicket.MedicalTests;
                        break;
                    case "XRays":
                        pt = PrescriptionTicket.XRays;
                        break;
                }

                JPAPatientDAO jpatient = new JPAPatientDAO();
                Patient patient = jpatient.getById(cnp_patient);
                JPADoctorDAO jdoctor = new JPADoctorDAO();
                Doctor doctor = jdoctor.getById(cnp_doctor);
                Consultation cons = new Consultation(app_date, doctor, patient, spec, diagnosis, obs, recipe, pt);
                toReturn.add(cons);
            }
            return toReturn;

        }
        catch(Exception ex)
        {
            MyLogger.Error("get consultations by patient",ex.toString());
            return null;
        }
    }

    public List<Consultation> getConsultationsByDoctor(String cnp_doctor)
    {
        String query = "select * from  clinic.consultation where cnp_doctor = '" + cnp_doctor+ "'";
        ResultSet result = null;
        List<Consultation> toReturn = new ArrayList<>();
        try {
            connection = DbConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(!result.next())
            {
                return null;
            }
            while (result.next()) {
                String cons_id = result.getString(1);
                String cnp_patient = result.getString(3);
                String specialization = result.getString(4);
                String diagnosis = result.getString(5);
                String obs = result.getString(6);
                String recipe = result.getString(7);
                String ticket = result.getString(8);
                Date app_date = result.getDate(9);

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
                }

                PrescriptionTicket pt = PrescriptionTicket.None;
                switch (ticket) {
                    case "MedicalTests":
                        pt = PrescriptionTicket.MedicalTests;
                        break;
                    case "XRays":
                        pt = PrescriptionTicket.XRays;
                        break;
                }

                JPAPatientDAO jpatient = new JPAPatientDAO();
                Patient patient = jpatient.getById(cnp_patient);
                JPADoctorDAO jdoctor = new JPADoctorDAO();
                Doctor doctor = jdoctor.getById(cnp_doctor);
                Consultation cons = new Consultation(app_date, doctor, patient, spec, diagnosis, obs, recipe, pt);
                toReturn.add(cons);
            }
            return toReturn;
        }
        catch(Exception ex)
        {
            MyLogger.Error("get consultations by doctor",ex.toString());
            return null;
        }
    }

}
