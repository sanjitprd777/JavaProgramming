package CricBuzz;

import CricBuzz.MatchType.OneDay;

public class Main {

    public static void main(String[] args) {

        Match match = new Match(new OneDay());

        match.startMatch();
    }
}
