package CricBuzz.Team;

import CricBuzz.Team.Players.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

@NoArgsConstructor
@Getter
@Setter
public class PlayerBattingController {

    Queue<Player> players = new LinkedList<>();
    Player striker;
    Player non_striker;
}
