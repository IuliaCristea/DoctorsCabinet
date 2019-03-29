import java.util.Set;

public class Hospital {
    private String Name;
    private Address Address;
    private Set<Doctor> Doctors;
    private Set<Specialization> Specializations;

    public Hospital(String name, Address address, Set<Doctor> doctors, Set<Specialization> specializations) {
        Name = name;
        Address = address;
        Doctors = doctors;
        Specializations = specializations;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address address) {
        Address = address;
    }

    public Set<Doctor> getDoctors() {
        return Doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        Doctors = doctors;
    }

    public Set<Specialization> getSpecializations() {
        return Specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        Specializations = specializations;
    }
}
