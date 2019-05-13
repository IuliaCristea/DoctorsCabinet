package Classes;

import java.text.ParseException;

public class Patient extends Person {


    public Patient(String firstName, String lastName, String cnp, String birthDate, String gender,
                   String address, String phone) throws ParseException {
        super(firstName,lastName, cnp, birthDate, gender,
            address,phone);

    }



}


