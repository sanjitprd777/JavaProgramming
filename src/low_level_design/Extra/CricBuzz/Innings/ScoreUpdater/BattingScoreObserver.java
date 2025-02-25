package CricBuzz.Innings.ScoreUpdater;

import CricBuzz.Innings.Ball;
import CricBuzz.Innings.BallType;
import CricBuzz.Innings.RunType;
import CricBuzz.Team.Players.Player;

public class BattingScoreObserver implements ScoreObserver {
    Ball ball;

    public BattingScoreObserver(Ball ball) {
        this.ball = ball;
        this.ball.addScoreObservers(this);
    }

    @Override
    public void update() {
        Player batsman = ball.getPlayedBy();
        batsman.getBattingScoreCard().setBowlsPlayed(batsman.getBattingScoreCard().getBowlsPlayed() + 1);
        switch (ball.getRunType()) {
            case ONE -> batsman.getBattingScoreCard().setRuns(batsman.getBattingScoreCard().getRuns() + 1);
            case TWO -> batsman.getBattingScoreCard().setRuns(batsman.getBattingScoreCard().getRuns() + 2);
            case THREE -> batsman.getBattingScoreCard().setRuns(batsman.getBattingScoreCard().getRuns() + 3);
            case FOUR -> {
                batsman.getBattingScoreCard().setRuns(batsman.getBattingScoreCard().getRuns() + 4);
                batsman.getBattingScoreCard().setFours(batsman.getBattingScoreCard().getFours() + 1);
            }
            case FIVE -> batsman.getBattingScoreCard().setRuns(batsman.getBattingScoreCard().getRuns() + 5);
            case SIX -> {
                batsman.getBattingScoreCard().setRuns(batsman.getBattingScoreCard().getRuns() + 6);
                batsman.getBattingScoreCard().setSixes(batsman.getBattingScoreCard().getSixes() + 1);
            }
            default -> batsman.getBattingScoreCard().setRuns(batsman.getBattingScoreCard().getRuns());
        }
        batsman.getBattingScoreCard().setStrikeRate(115.0);
    }
}
