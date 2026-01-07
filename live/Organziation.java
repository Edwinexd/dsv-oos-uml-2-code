import java.util.ArrayList;

public class Organziation {
    private int id;
    private ArrayList<Award> issuedAwards;

    public Organziation(int id, ArrayList<Award> awards) {
        this.id = id;
        if (!eitherNoAwardsOrAllValid()) {
            throw new IllegalStateException("Felaktiga motiveringar");
        }
        issuedAwards = awards;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Award> getIssuedAwards() {
        return issuedAwards;
    }

    private boolean eitherNoAwardsOrAllValid() {
        if (issuedAwards.isEmpty()) {
            return true;
        }
        for (Award a : issuedAwards) { 
            if (a == null) {
                return false;
            }
        }
        return true;
    }
}
