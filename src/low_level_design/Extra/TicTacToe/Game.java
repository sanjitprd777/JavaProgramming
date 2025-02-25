package TicTacToe;

import TicTacToe.Model.Board;
import TicTacToe.Model.PieceO;
import TicTacToe.Model.PieceX;
import TicTacToe.Model.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {

    Deque<Player> players;
    Player winner;
    Board board;

    Game() {
        this.board = new Board();
        players = new ArrayDeque<>();
        winner = null;

        Player player1 = new Player("Sahil", new PieceO());
        Player player2 = new Player("Sanjit", new PieceX());

        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            board.printBoard();
            // Check if space left on board.
            if (!board.checkSpaceLeft()) {
                System.out.println("Match Tie!");
                return;
            }

            // Player plays the game
            Player player = players.removeFirst();

            // Take input [row, col] from player
            System.out.print("Waiting for player " + player.getName() + " to provide input: ");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            // Validate input
            if (!board.play(row, col, player.getPlayingPiece())) {
                System.out.println("Incorrect move, please try again!");
                players.addFirst(player);
                continue;
            }

            if (board.checkWinner(row, col, player.getPlayingPiece())) {
                winner = player;
                break;
            }

            players.addLast(player);
        }
        board.printBoard();
        System.out.println("**************************************************");
        System.out.println("Winner of this game is: " + winner.getName());
        System.out.println("**************************************************");
    }

}
