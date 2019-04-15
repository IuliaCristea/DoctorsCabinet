package DAO;

import Classes.Hospital;

import java.util.Iterator;
import java.util.Set;

public class HospitalDAO {

    Set<Hospital> Hospitals;

    void addHospital(Hospital hospital)
    {
        Hospitals.add(hospital);
    }

    void removeHospital(Hospital hospital)
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

    void editHospital(Hospital hospital)
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
