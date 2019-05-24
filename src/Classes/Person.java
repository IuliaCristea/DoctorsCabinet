package Classes;

import java.text.ParseException;


public abstract class Person {
    private String firstName;
    private String lastName;
    private String cnp;
    private String birthDate;
    private String gender;
    private Address address;
    private String phone;

    protected Person(String firstName, String lastName, String cnp, String birthDate, String gender,
                  String address, String phone) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.address = new Address(address);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCNP() {
        return cnp;
    }

    public String getDateOfBirth() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public String getAddressString(){
        String s = this.address.getStreet() + " " + this.address.getBuilding() + " " + this.address.getApartment() + " " + this.address.getTown();
        return s;
    }

    public String getPhone() {
        return phone;
    }

}
