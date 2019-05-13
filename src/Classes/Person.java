package Classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Person {
    private String FirstName;
    private String LastName;
    private String CNP;
    private Date DateOfBirth;
    private String Gender;
    private String Address;
    private String Phone;

    protected Person(String firstName, String lastName, String cnp, String birthDate, String gender,
                  String address, String phone) throws ParseException {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.CNP = cnp;
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        this.DateOfBirth = formatter.parse(birthDate);
        this.Gender = gender;
        this.Phone = phone;
        this.Address = address;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }


    public void setGender(String gender) {
        Gender = gender;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


    public void setAddress(String address)
    {
        this.Address = address;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCNP() {
        return CNP;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

}
