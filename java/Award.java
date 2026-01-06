import java.time.LocalDateTime;
import java.util.LinkedList;

public class Award {
    public static final LinkedList<Award> ALL_AWARDS = new LinkedList<Award>();

    private LocalDateTime at;
    private String motivation;
    private LocalDateTime editedAt;
    private Organisation issuer;
    private Game forGame;

    public Award(String motivation, LocalDateTime at, Organisation issuer, Game forGame) {
        this.motivation = motivation;
        this.at = at;
        this.issuer = issuer;
        this.forGame = forGame;
        ALL_AWARDS.add(this);
    }

    public Organisation getIssuer() { return issuer; }

    public LocalDateTime getDate() { return at; }

    public String getMotivation() { return motivation; }

    public Game getForGame() { return forGame; }

    private void setEdited() {
        this.editedAt = LocalDateTime.now();
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
        setEdited();
    }
    
}
