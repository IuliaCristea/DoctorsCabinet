import java.util.Iterator;
import java.util.Set;

public class HospitalDAO {

    private Set<Hospital> Hospitals;

    public void addHospital(Hospital hospital)
    {
        Hospitals.add(hospital);
    }

    public void removeHospital(Hospital hospital)
    {
        Iterator<Hospital> iterator = Hospitals.iterator();
        iterator.hasNext();
        {
            Hospital h = iterator.next();
            if (h.getName() == hospital.getName())
            {
                iterator.remove();
            }
        }
    }

    public void editHospital(Hospital hospital)
    {
        Iterator<Hospital> iterator = Hospitals.iterator();
        iterator.hasNext();
        {
            Hospital h = iterator.next();
            if (h.getName() == hospital.getName())
            {
                h = hospital;
            }
        }
    }


}
