package CricBuzz.Innings;

import CricBuzz.Team.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Inning {

    public Team battingTeam;
    public Team bowlingTeam;
    public int overs;

    public void startInning(int inningCount) {
        // Logic
        System.out.println("Inning started: " + inningCount);
    }
}
