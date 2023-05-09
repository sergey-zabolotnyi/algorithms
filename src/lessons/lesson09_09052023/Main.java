package lessons.lesson09_09052023;

public class Main {
    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] array = new int[n+1][m+1];
        array[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || j == 1) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i-1][j] + array[i][j-1];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
