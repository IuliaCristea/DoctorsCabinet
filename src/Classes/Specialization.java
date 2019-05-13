package Classes;

public enum Specialization {
    Pediatrics(0),
    Neurology(1),
    Cardiology(2),
    Surgery(3),
    Gastroenterology(4),
    FamilyMedicine(5),
    LaborMedicine(6),
    Ophthalmology(7),
    Psychology(8),
    Dentistry(9),
    None(10);

    private final int value;
    private Specialization(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
