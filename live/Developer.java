import java.util.ArrayList;

public class Developer extends Employee {
    private ArrayList<AcademicDiploma> earned;

    public Developer(String name, ArrayList<AcademicDiploma> diploms) {
        super(name);
        earned.addAll(diploms);

    }
}
    
