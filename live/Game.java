import java.util.ArrayList;

public class Game {
    private String title;
    private String description;
    private ArrayList<Developer> developedBy;

    public Game(String title, String description, ArrayList<Developer> develoeprs) {
        this.title = title;
        this.description = description;
        if (develoeprs.size() > 0) {
            throw new IllegalStateException();
        }
        this.developedBy.addAll(develoeprs);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Developer> getDevelopers() {
        return developedBy;
    }
    
}
