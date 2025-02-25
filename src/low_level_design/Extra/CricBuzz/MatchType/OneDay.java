package CricBuzz.MatchType;

public class OneDay implements MatchType {

    int overs;
    int overVsBowler;

    public OneDay() {
        this.overs = numberOfOvers();
        this.overVsBowler = maxOverBowler();
    }

    @Override
    public int numberOfOvers() {
        return 50;
    }

    @Override
    public int maxOverBowler() {
        return 10;
    }
}
