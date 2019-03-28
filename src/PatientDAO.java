import java.util.Iterator;
import java.util.Set;

public class PatientDAO {

    Set<Patient> Patients;

    void addPatient(Patient patient) {
        Patients.add(patient);
    }

    void removePatient(Patient patient)
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

    void editPatient(Patient patient)
    {
        Iterator<Patient> iterator = Patients.iterator();
        iterator.hasNext();
        {
            Patient p = iterator.next();
            if (p == patient)
            {
                p = patient;
            }
        }
    }

    void addHistory(Patient patient, Consultation consultation)
    {
        Iterator<Patient> iterator = Patients.iterator();
        iterator.hasNext();
        {
            Patient p = iterator.next();
            if (p == patient)
            {
                p.History.addConsultation(consultation);
            }
        }
    }
}
