package Classes;

import java.util.Queue;

public class Doctor extends Person {

    private Specialization Specialization;
    private static Queue<Patient> WaitingQueue;

    public Doctor(String firstName, String lastName, String cnp, String birthDate, int age, String gender,
                  String street, int streetNumber, String building, int floor, int apRoom)
    {
        super(firstName, lastName, cnp, birthDate, age, gender, street, streetNumber, building, floor, apRoom);
    }

    public Specialization getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(Specialization specialization) {

        Specialization = specialization;
    }

    public Queue<Patient> getWaitingQueue()
    {
        return WaitingQueue;
    }

}
