import java.lang.reflect.GenericArrayType;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Dictionary;


public class Person {
    protected String FirstName;
    protected String LastName;
    protected String CNP;
    protected LocalDate DateOfBirth;
    protected int Age;
    protected String Gender;
    protected Address Address;
    protected String Phone;

    //protected Dictionary<Date, Dictionary<MedicalDepartment, Diagnosis>> History;

    public Person(String firstName, String lastName, String cnp, String birthDate, int age, String gender,
                  String street, int streetNumber, String building, int floor, int apRoom)
    {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.CNP = cnp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.DateOfBirth = LocalDate.parse(birthDate, formatter);

        LocalDate currentDate = LocalDate.now();
        this.Age = Period.between(DateOfBirth, currentDate).getYears();
        this.Gender = gender;
        setAddress(street, streetNumber, building, floor, apRoom);
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

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


    public void setAddress(String street, int streetNumber, String building, int floor, int apRoom)
    {
        this.Address.setStreet(street);
        this.Address.setStreetNumber(streetNumber);
        this.Address.setBuilding(building);
        this.Address.setFloor(floor);
        this.Address.setApartmentOrRoom(apRoom);
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

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public int getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public Address getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

}
