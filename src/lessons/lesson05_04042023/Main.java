package lessons.lesson05_04042023;
public class Main {
    public static void main(String[] args) {
        System.out.println(powIter(2,3));
        System.out.println(powRecur(2,3));
        System.out.println(powRecur2(2,3));
        int [][] array = {{1,2,3},{4,5,6},{7,8,9}};
        task2(array);

    }
    private static void task2(int[][] array){
        int n = array.length;       // количество строк
        int m = array[0].length;    // количество столбцов
        int[][] table = new int [n+2][m+2]; // массив обвертка

        int max = array[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] > max){
                    max = array[i][j];
                }
            }
        }
        max *= 10;
        for (int i = 0; i < n + 2; i++) {
            table[i][0] = max;      // записали max в 0й столбец
            table[i][m+1] = max;
        }
        for (int j = 0; j < n + 2; j++) {
            table[0][j] = max;
            table[n+1][j] = max;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i+1][j+1] = array[i][j];
            }
        }
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < m+2; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (table[i][j] <= table[i-1][j] &&
                table[i][j] <= table[i+1][j] &&
                table[i][j] <= table[i][j-1] &&
                table[i][j] <= table[i][j+1]){
                    System.out.println(table[i][j]);
                }
            }
        }
    }
    private static int powIter(int x, int n){
        int p = 1;
        for (int i = 0; i < n; i++) {
            p = p * x;
        }
        return p;
    }
    private static int powRecur(int x, int n){
        if (n == 0){
            return 1;
        }
        return  x * powRecur(x, n-1);
    }
    private static int powRecur2(int x, int n){
        if (n == 0){
            return 1;
        }
        int y = powRecur2(x, n / 2);
        if(n % 2 == 0){
            return y * y;
        } else {
            return x * y * y;
        }
    }

}
