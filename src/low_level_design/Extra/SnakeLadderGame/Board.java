package SnakeLadderGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {
    Cell[][] cells;
    int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        initializeBoard();
    }

    void initializeBoard() {
        initializeCells();
        addSnakeLadder(5, 5);
    }

    void initializeCells() {
        cells = new Cell[boardSize][boardSize];

        for(int i=0; i<boardSize; ++i) {
            for(int j=0; j<boardSize; ++j) {
                Cell cell = new Cell(null);
                cells[i][j] = cell;
            }
        }
    }

    void addSnakeLadder(int snakeCount, int ladderCount) {
        // Contains all cell positions already occupied and default cells.
        Set<Integer> occupiedCells = new HashSet<>();
        occupiedCells.add(0);
        occupiedCells.add(99);

        Random random = new Random();

        // Adding Snake
        while (snakeCount > 0) {
            int start = random.nextInt(boardSize*boardSize - 1) + 1;
            int end = random.nextInt(boardSize*boardSize - 1) + 1;
            if (start <= end || occupiedCells.contains(start) || occupiedCells.contains(end)) {
                continue;
            }
            occupiedCells.add(start);
            occupiedCells.add(end);
            int row = start/boardSize;
            int col = start%boardSize;
            Cell cell = cells[row][col];
            if (cell.jump == null) {
                cell.jump = new Jump(start, end);
            }
            snakeCount--;
        }

        // Adding Ladder
        while (ladderCount > 0) {
            int start = random.nextInt(boardSize*boardSize - 1) + 1;
            int end = random.nextInt(boardSize*boardSize - 1) + 1;
            if (start >= end || occupiedCells.contains(start) || occupiedCells.contains(end)) {
                continue;
            }
            occupiedCells.add(start);
            occupiedCells.add(end);
            int row = start/boardSize;
            int col = start%boardSize;
            Cell cell = cells[row][col];
            if (cell.jump == null) {
                cell.jump = new Jump(start, end);
            }
            ladderCount--;
        }
    }
}
