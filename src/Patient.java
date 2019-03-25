import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Dictionary;

public class Patient {
    public String FirstName;
    public String LastName;
    public String CNP;
    public LocalDate DateOfBirth;
    public int Age;
    protected Dictionary<Date, Dictionary<MedicalDepartment, Diagnosis>> History;

    public Patient(String firstName, String lastName, String cnp, String birthDate)
    {
        FirstName = firstName;
        LastName = lastName;
        CNP = cnp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateOfBirth = LocalDate.parse(birthDate, formatter);

        LocalDate currentDate = LocalDate.now();
        Age = Period.between(DateOfBirth, currentDate).getYears();
    }

















    public static void main(String[] args){
            Patient p1 = new Patient("Ion","Popescu","021544788552","22/12/1987");
            System.out.print(p1.FirstName+ " " + p1.Age+ " " + p1.LastName+ " " + p1.CNP+ " " + p1.DateOfBirth+ " " + LocalDate.now());
    }


}


