package CricBuzz.Team;

import CricBuzz.Team.Players.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class PlayerBowlingController {

    Deque<Player> players = new LinkedList<>();
    Map<Player, Integer> playerOverCount = new HashMap<>();
    Player currentBowler;
}
