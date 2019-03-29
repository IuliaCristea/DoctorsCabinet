import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Dictionary;

public class Patient extends Person{

    private  History History;

    public Patient(String firstName, String lastName, String cnp, String birthDate, int age, String gender,
                   String street, int streetNumber, String building, int floor, int apRoom)
    {
        super(firstName,lastName, cnp, birthDate,age, gender,
            street,streetNumber,  building, floor, apRoom);

    }

    public History getHistory() {
        return History;
    }

    public void setHistory(History history) {
        History = history;
    }

}


