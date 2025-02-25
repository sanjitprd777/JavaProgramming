package CricBuzz.Team.Players;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Player {

    String name;
    int age;
    PlayerType playerType;
    BattingScoreCard battingScoreCard;
    BowlingScoreCard bowlingScoreCard;
}
