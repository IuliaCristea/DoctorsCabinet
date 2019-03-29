import java.util.Set;

public class History {

    private Set<Consultation> History;

    public Set<Consultation> getHistory() {
        return History;
    }

    public void setHistory(Set<Consultation> history) {
        History = history;
    }

    public void addConsultation(Consultation consultation)
    {
        History.add(consultation);
    }
}
