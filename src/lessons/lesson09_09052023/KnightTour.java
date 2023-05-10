package lessons.lesson09_09052023;

import java.util.ArrayList;
import java.util.List;

public class KnightTour {

    private static final int BOARD_SIZE = 8;
    private static final int[][] MOVES = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private static int movesCount = 0;

    public static void main(String[] args) {
        solve(0, 0);
        printSolution();
    }

    private static void solve(int row, int col) {
        board[row][col] = ++movesCount;
        if (movesCount == BOARD_SIZE * BOARD_SIZE) {
            return; // found a solution
        }

        List<int[]> validMoves = getValidMoves(row, col);
        for (int[] move : validMoves) {
            int nextRow = move[0];
            int nextCol = move[1];
            solve(nextRow, nextCol);
            if (movesCount == BOARD_SIZE * BOARD_SIZE) {
                return; // found a solution
            }
        }

        // backtrack
        board[row][col] = 0;
        movesCount--;
    }

    private static List<int[]> getValidMoves(int row, int col) {
        List<int[]> validMoves = new ArrayList<>();
        for (int[] move : MOVES) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if (isValidMove(nextRow, nextCol)) {
                validMoves.add(new int[]{nextRow, nextCol});
            }
        }
        return validMoves;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0;
    }

    private static void printSolution() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }
}
