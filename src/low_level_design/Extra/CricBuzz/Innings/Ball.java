package CricBuzz.Innings;

import CricBuzz.Innings.ScoreUpdater.ScoreObserver;
import CricBuzz.Team.Players.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Ball {

    int ballNumber;
    BallType ballType;
    RunType runType;
    Player playedBy;
    Player bowledBy;
    List<ScoreObserver> scoreObservers;

    public Ball(int ballNumber, BallType ballType, RunType run, Player playedBy,
                Player bowledBy) {
        this.ballNumber = ballNumber;
        this.ballType = ballType;
        this.runType = run;
        this.playedBy = playedBy;
        this.bowledBy = bowledBy;
        this.scoreObservers = new ArrayList<>();
    }

    public void addScoreObservers(ScoreObserver scoreObserver) {
        this.scoreObservers.add(scoreObserver);
    }

    public void clearScoreObserver() {
        this.scoreObservers.clear();
    }

    public void startBowling() {

    }

    public void notifyObserver() {
        for (ScoreObserver scoreObserver : scoreObservers)
            scoreObserver.update();
    }
}
