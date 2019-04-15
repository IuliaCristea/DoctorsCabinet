package DAO;
import Classes.Consultation;
import Classes.History;
import Classes.Patient;
import java.util.Iterator;
import java.util.Set;

public class PatientDAO {

    private static Set<Patient> Patients;

    public Set<Patient> getPatients()
    {
        return Patients;
    }

    public void addPatient(Patient patient) {
        Patients.add(patient);
    }

    public void removePatient(Patient patient)
    {
        Iterator<Patient> iterator = Patients.iterator();
        iterator.hasNext();
        {
            Patient p = iterator.next();
            if (p == patient)
            {
                iterator.remove();
            }
        }
    }

    public void editPatient(Patient patient)
    {
        Iterator<Patient> iterator = Patients.iterator();
        iterator.hasNext();
        {
            Patient p = iterator.next();
            if (p.getCNP() == patient.getCNP())
            {
                p = patient;
            }
        }
    }

    public void addHistory(Patient patient, Consultation consultation)
    {
        Iterator<Patient> iterator = Patients.iterator();
        iterator.hasNext();
        {
            Patient p = iterator.next();
            if (p == patient)
            {
                History h = p.getHistory();
                h.addConsultation(consultation);
                p.setHistory(h);
            }
        }
    }
}
