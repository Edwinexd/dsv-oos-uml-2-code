import java.util.LinkedList;
import java.util.List;

public class Game {
    private String title;
    private String description;
    private List<Developer> developedBy = new LinkedList<>();

    public Game(String title, String description, Iterable<Developer> developedBy) {
        this.title = title;
        this.description = description;
        for (Developer developer : developedBy) {
            this.developedBy.add(developer);
        }
        if (this.developedBy.size() == 0) {
            throw new IllegalArgumentException("A game must have at least one developer");
        }
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public Iterable<Developer> getDevelopers() { return developedBy; }
}
