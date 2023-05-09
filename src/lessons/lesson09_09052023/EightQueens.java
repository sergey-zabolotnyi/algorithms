package lessons.lesson09_09052023;
public class EightQueens {

    private static final int BOARD_SIZE = 8;
    private static int[] queens = new int[BOARD_SIZE];
    private static int solutionsCount = 0;

    public static void main(String[] args) {
        solve(0);
        System.out.println("Найдено " + solutionsCount + " решений.");
    }

    private static void solve(int row) {
        if (row == BOARD_SIZE) {
            printSolution();
            solutionsCount++;
            return;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isValidPosition(row, col)) {
                queens[row] = col;
                solve(row + 1);
            }
        }
    }

    private static boolean isValidPosition(int row, int col) {
        for (int i = 0; i < row; i++) {
            int otherCol = queens[i];
            if (col == otherCol) { // same column
                return false;
            }
            if (row - i == Math.abs(col - otherCol)) { // same diagonal
                return false;
            }
        }
        return true;
    }

    private static void printSolution() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}