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

    public boolean checkAwardWinningRequiresQualifiedTeam() {
        // Award.allInstances()->exists(a | a.forGame = self)
        boolean hasAward = Award.ALL_AWARDS.stream()
            .anyMatch(a -> a.getForGame() == this);
        
        // implies: if no award, constraint is satisfied
        if (!hasAward) {
            return true;
        }
        
        // developedBy->forAll(d | d.earned->includes(...) or ...)
        return developedBy.stream()
            .allMatch(d -> 
                d.getEarned().contains(AcademicDiploma.MASTER) ||
                d.getEarned().contains(AcademicDiploma.LICENTIATE) ||
                d.getEarned().contains(AcademicDiploma.DOCTORATE)
            );
    }
}
