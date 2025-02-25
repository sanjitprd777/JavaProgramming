package CricBuzz.Team.Players;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BowlingScoreCard {

    int oversBowled;
    int runs;
    int wickets;
    int wideBall;
    int noBall;
    Double economy;
}
