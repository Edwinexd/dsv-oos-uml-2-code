import java.time.LocalDateTime;

public class Award {
    private LocalDateTime at;
    private String motivation;
    private LocalDateTime edited; // can be NULL

    private Organziation issuedBy;
    private Game forGame;

    public Award(String motivation, LocalDateTime at, Organziation org, Game game) {
        this.motivation = motivation;
        this.at = at;
        this.issuedBy = org;
        this.forGame = game;
    }

    private void setEdited() {
        this.edited = LocalDateTime.now();
    }

    public void setMotivation(String newMotivation) {
        motivation = newMotivation;
        setEdited();
    }

    public String getGameTitle() {
        return forGame.getTitle();
    }
}
