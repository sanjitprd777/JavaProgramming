package CricBuzz.Team.Players;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BattingScoreCard {

    int runs;
    int bowlsPlayed;
    int fours;
    int sixes;
    Double strikeRate;
}
