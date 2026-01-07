public class Employee {
    private String name;

    public Employee(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Felaktigt namn");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static boolean isValidName(String name) {
        if (name.split(" ").length > 2) {
            return true;
        }
        return false;
    }
}
