package TicTacToe.Model;

public class Board {

    PlayingPiece[][] board;
    int size;

    public Board() {
        initialize();
    }

    void initialize() {
        this.size = 3;
        board = new PlayingPiece[size][size];
//        for (int i=0; i<size; ++i) {
//            for (int j=0; j<size; ++j) {
//                board[i][j] = new PlayingPiece(null);
//            }
//        }
    }

    public boolean play(int row, int col, PlayingPiece playingPiece) {
        if (board[row][col] != null)
            return false;
        board[row][col] = playingPiece;
        return true;
    }

    public boolean checkSpaceLeft() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j]==null)
                    return true;
            }
        }
        return false;
    }

    public boolean checkWinner(int row, int col, PlayingPiece playingPiece) {
        boolean allFill = true;
        // Check current row.
        for (int i = 0; i < size; ++i) {
            if (playingPiece != board[row][i]) {
                allFill = false;
            }
        }
        if (allFill)    return true;

        allFill = true;
        // Check current col.
        for (int i = 0; i < size; ++i) {
            if (playingPiece != board[i][row]) {
                allFill = false;
            }
        }
        if (allFill)    return true;

        // Check forward diagonal
        allFill = true;
        for (int i = 0; i < size; ++i) {
            if (playingPiece != board[i][i]) {
                allFill = false;
                break;
            }
        }
        if (allFill)    return true;

        // Check backward diagonal
        allFill = true;
        for (int i = 0; i < size; ++i) {
            if (playingPiece != board[i][size-i-1]) {
                allFill = false;
                break;
            }
        }
        return allFill;
    }

    public void printBoard() {
        for(int s=0; s<=size; ++s) {
            for (int i = 0; i < size; ++i) {
                System.out.print(" -");
            }
            System.out.print("\n");
            if (s != size) {
                for (int i = 0; i <= size; ++i) {
                    System.out.print("|");
                    if (i != size) {
                        if (board[s][i] != null)
                            System.out.print(board[s][i].pieceType);
                        else
                            System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
        }
    }
}
