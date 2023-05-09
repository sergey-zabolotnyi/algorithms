package lessons.lesson09_09052023;

public class Main1 {
    public static void main(String[] args) {
        int[][] field = new  int[8][8];
    }
    private static void addQueen(int row, int column, int[][] field){
        for (int i = 0; i < 8; i++) {
            field[row][i]++;
            field[i][column]++;
        }
        int i = row, j = column;
        while (i<8 && j<8){
            field[i][j]++;
            i++;
            j--;
        }
    }
}
