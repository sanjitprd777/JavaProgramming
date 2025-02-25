package CricBuzz.Innings.ScoreUpdater;

import CricBuzz.Innings.Ball;
import CricBuzz.Innings.BallType;
import CricBuzz.Team.Players.Player;

public class BowlingScoreObserver implements ScoreObserver {

    Ball ball;

    public BowlingScoreObserver(Ball ball) {
        this.ball = ball;
        this.ball.addScoreObservers(this);
    }

    @Override
    public void update() {
        Player bowler = ball.getBowledBy();
        if (ball.getBallNumber() == 6)
            bowler.getBowlingScoreCard().setOversBowled(bowler.getBowlingScoreCard().getOversBowled() + 1);
        switch (ball.getRunType()) {
            case ONE -> bowler.getBowlingScoreCard().setRuns(bowler.getBowlingScoreCard().getRuns() + 1);
            case TWO -> bowler.getBowlingScoreCard().setRuns(bowler.getBowlingScoreCard().getRuns() + 2);
            case THREE -> bowler.getBowlingScoreCard().setRuns(bowler.getBowlingScoreCard().getRuns() + 3);
            case FOUR -> bowler.getBowlingScoreCard().setRuns(bowler.getBowlingScoreCard().getRuns() + 4);
            case FIVE -> bowler.getBowlingScoreCard().setRuns(bowler.getBowlingScoreCard().getRuns() + 5);
            case SIX -> bowler.getBowlingScoreCard().setRuns(bowler.getBowlingScoreCard().getRuns() + 6);
        }
        if (BallType.WICKET.equals(ball.getBallType())) {
            bowler.getBowlingScoreCard().setWickets(bowler.getBowlingScoreCard().getWickets() + 1);
        }
        if (BallType.WIDE.equals(ball.getBallType())) {
            bowler.getBowlingScoreCard().setWideBall(bowler.getBowlingScoreCard().getWideBall() + 1);
        }
        if (BallType.NO_BALL.equals(ball.getBallType())) {
            bowler.getBowlingScoreCard().setNoBall(bowler.getBowlingScoreCard().getNoBall() + 1);
        }
        bowler.getBowlingScoreCard().setEconomy(1.15);
    }
}
