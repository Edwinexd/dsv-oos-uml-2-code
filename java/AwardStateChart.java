import java.time.LocalDateTime;

public class AwardStateChart {
    
    public enum State {
        DRAFT,
        ISSUED,
        EDITED,
        ARCHIVED
    }
    
    private State currentState;
    private LocalDateTime setAt;
    private String motivation;
    private boolean edited;
    private Organisation organization;
    
    // Constructor - corresponds to "new Award()" transition to Draft
    public AwardStateChart() {
        this.currentState = State.DRAFT;
        this.setAt = LocalDateTime.now(); // entry / set at = now()
    }
    
    // Transition: Draft -> Issued via submit(Organization)
    public void submit(Organisation organization) {
        if (currentState != State.DRAFT) {
            throw new IllegalStateException("Can only submit from Draft state");
        }
        this.organization = organization;
        this.currentState = State.ISSUED;
        notifyGameDevelopers(); // do / notify game developers
    }
    
    // Transition: Issued -> Edited via setMotivation(String)
    // Also: Edited -> Edited (self-loop) via setMotivation(String)
    public void setMotivation(String motivation) {
        if (currentState != State.ISSUED && currentState != State.EDITED) {
            throw new IllegalStateException("Can only set motivation from Issued or Edited state");
        }
        this.motivation = motivation;
        this.currentState = State.EDITED;
        setEdited(); // entry / setEdited()
    }
    
    // Transition: Issued -> Archived via archive()
    // Transition: Edited -> Archived via archive()
    public void archive() {
        if (currentState != State.ISSUED && currentState != State.EDITED) {
            throw new IllegalStateException("Can only archive from Issued or Edited state");
        }
        this.currentState = State.ARCHIVED;
    }
    
    // Internal action for Issued state
    private void notifyGameDevelopers() {
        // Implementation for notifying game developers
        System.out.println("Notifying game developers about the award...");
    }
    
    // Entry action for Edited state
    private void setEdited() {
        this.edited = true;
    }
}
