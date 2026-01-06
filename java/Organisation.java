import java.util.LinkedList;
import java.util.List;

public class Organisation {
    private int id;
    private List<Award> issuedAwards = new LinkedList<>();

    public Organisation(int id, Iterable<Award> issuedAwards) {
        this.id = id;
        for (Award award : issuedAwards) {
            this.issuedAwards.add(award);
        }
    }

    public int getId() { return id; }

    public Iterable<Award> getIssuedAwards() { return issuedAwards; }

    public boolean checkOneAwardPerGamePerYear() {
        // issuedAwards->forAll(a1, a2 | ...)
        for (Award a1 : issuedAwards) {
            for (Award a2 : issuedAwards) {
                // (a1 <> a2 and a1.forGame = a2.forGame)
                boolean premise = (a1 != a2) && 
                    (a1.getForGame() == a2.getForGame());
                
                // implies a1.at.year() <> a2.at.year()
                if (premise) {
                    boolean conclusion = 
                        a1.getDate().getYear() != a2.getDate().getYear();
                    
                    // implies: if premise is true, conclusion must be true
                    if (!conclusion) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
