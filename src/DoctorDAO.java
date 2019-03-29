import java.util.Iterator;
import java.util.Set;

public class DoctorDAO {
    Set<Doctor> Doctors;

    void addDoctor(Doctor doctor)
    {
        Doctors.add(doctor);
    }

    void removeDoctor(Doctor doctor)
    {
        Iterator<Doctor> iterator = Doctors.iterator();
        iterator.hasNext();
        {
            Doctor d = iterator.next();
            if (d == doctor)
            {
                iterator.remove();
            }
        }
    }

    void editDoctor(Doctor doctor)
    {
        Iterator<Doctor> iterator = Doctors.iterator();
        iterator.hasNext();
        {
            Doctor d = iterator.next();
            if (d.getCNP() == doctor.getCNP())
            {
                d=doctor;
            }
        }
    }
}
