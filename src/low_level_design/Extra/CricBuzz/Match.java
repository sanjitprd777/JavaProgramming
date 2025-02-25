package CricBuzz;

import CricBuzz.Innings.Inning;
import CricBuzz.MatchType.MatchType;
import CricBuzz.Team.Team;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Match {

    MatchType matchType;
    Team teamA;
    Team teamB;
    Inning[] innings;

    public Match(MatchType matchType) {
        this.matchType = matchType;
        innings = new Inning[2];
    }

    public void startMatch() {
        // First Inning
        innings[0] = new Inning();
        innings[0].setBattingTeam(teamA);
        innings[0].setBowlingTeam(teamB);
        innings[0].setOvers(matchType.numberOfOvers());
        innings[0].startInning(1);

        // Second Inning
        innings[1] = new Inning();
        innings[1].setBattingTeam(teamB);
        innings[1].setBowlingTeam(teamA);
        innings[1].setOvers(matchType.numberOfOvers());
        innings[1].startInning(2);
    }
}
