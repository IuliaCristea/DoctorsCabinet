package Classes;

import java.text.ParseException;

public class Doctor extends Person {

    private Specialization Specialization;

    public Doctor(String firstName, String lastName, String cnp, String birthDate, String gender,
                  String address, String phone) throws ParseException {
        super(firstName, lastName, cnp, birthDate, gender,address, phone);
    }

    public Specialization getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(Specialization specialization) {

        Specialization = specialization;
    }

}
