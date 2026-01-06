import java.util.LinkedList;
import java.util.List;

public class Developer extends Employee {
    private List<AcademicDiploma> earned = new LinkedList<>();

    public Developer(String name, Iterable<AcademicDiploma> diplomas) {
        super(name);
        for (AcademicDiploma diploma : diplomas) {
            earned.add(diploma);
        }
    }

    public List<AcademicDiploma> getEarned() { return new LinkedList<>(earned); }
}
