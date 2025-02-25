package CricBuzz.MatchType;

public class T20 implements MatchType {

    int overs;
    int overVsBowler;

    public T20() {
        this.overs = numberOfOvers();
        this.overVsBowler = maxOverBowler();
    }

    @Override
    public int numberOfOvers() {
        return 20;
    }

    @Override
    public int maxOverBowler() {
        return 5;
    }

}
