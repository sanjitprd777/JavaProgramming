package SnakeLadderGame;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Deque<Player> playerList = new LinkedList<>();
    Dice dice;
    Player winner;
    int boardSize;

    public Game() {
        initializeGame();
    }

    void initializeGame() {
        boardSize = 10;
        board = new Board(boardSize);
        dice = new Dice(1, 1, 6);
        addPlayers();
        winner = null;
    }

    void addPlayers() {
        Player player1 = new Player(1, "Sahil", 0);
        Player player2 = new Player(2, "Sanjit", 0);
        playerList.add(player1);
        playerList.add(player2);
    }

    void startGame() {
        while (winner == null) {
            // Get player turn
            Player player = getPlayer();
            System.out.println("\nPlaying: " + player.playerName);

            // Throw dice
            int diceValue = dice.rollDice();
            int newPosition = player.playerPosition + diceValue;

            // Check 'Jump' at new position
            newPosition = checkJump(newPosition);

            System.out.println("Current position: " + player.playerPosition +
                    " , New position: " + newPosition);

            // Check if crossed the board
            if (newPosition > boardSize*boardSize - 1) {
                winner = player;
                break;
            }
            player.playerPosition = newPosition;
        }
        System.out.println("****************************************************************************************");
        System.out.println("Winner of the Game is: " + winner.playerName);
        System.out.println("****************************************************************************************");
    }

    Player getPlayer() {
        Player player = playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }

    int checkJump(int position) {
        if (position > boardSize*boardSize - 1) {
            return position;
        }
        int row = position / boardSize;
        int col = position % boardSize;

        Cell cell = board.cells[row][col];
        if (cell.jump != null) {
            if (cell.jump.start > cell.jump.end) {
                System.out.println("Bitten by Snake");
            } else {
                System.out.println("Taken a Ladder");
            }
            return cell.jump.end;
        }
        return position;
    }
}
