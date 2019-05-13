package Classes;

public enum PrescriptionTicket {
    None(0),
    MedicalTests(1),
    XRays(2);

    private final int value;
    private PrescriptionTicket(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
