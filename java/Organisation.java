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
}
