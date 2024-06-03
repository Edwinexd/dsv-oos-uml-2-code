public class Employee {
    private String name;

    public Employee(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public static boolean isValidName(String name) {
        return name != null && name.length() > 0 && name.split(" ").length > 2;
    }

    public String getName() {
        return name;
    }
}
