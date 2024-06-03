import java.time.LocalDateTime;

public class Award {
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
    }

    public Organisation getIssuer() { return issuer; }

    public LocalDateTime getDate() { return at; }

    public String getMotivation() { return motivation; }

    private void setEdited() {
        this.editedAt = LocalDateTime.now();
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
        setEdited();
    }
    
}
