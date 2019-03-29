import java.util.Iterator;
import java.util.Set;

public class DoctorDAO {
    private Set<Doctor> Doctors;

    public void addDoctor(Doctor doctor)
    {
        Doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor)
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

    public void editDoctor(Doctor doctor)
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
