package homeWorks.homeWork04_28032023;

public class Task3 {
    // 3. Найдите пиковый элемент в двумерном массиве.
    // Элемент является пиковым, если он больше или равен своим четырем соседям слева,
    // справа, сверху и снизу. Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1].
    // Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
    // 10 20 15
    // 21 30 14
    // 7 16 32
    // Выход: 30
    // 30 — пиковый элемент, потому что все его
    // соседи меньше или равны ему.
    // 32 также можно выбрать в качестве пика.

    public static void main(String[] args) {

        int[][] array = {{10, 20, 15},{21, 30, 14},{7, 16, 32}};
        System.out.println(findPeakElement(array));
    }
    public static int findPeakElement(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int left = 0;
        int right = cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int maxRow = 0;
            for (int i = 1; i < rows; i++) {
                if (array[i][mid] > array[maxRow][mid]) {
                    maxRow = i;
                }
            }
            boolean isPeak = true;
            if (maxRow > 0 && array[maxRow - 1][mid] > array[maxRow][mid]) {
                isPeak = false;
            }
            if (maxRow < rows - 1 && array[maxRow + 1][mid] > array[maxRow][mid]) {
                isPeak = false;
            }
            if (mid > 0 && array[maxRow][mid - 1] > array[maxRow][mid]) {
                isPeak = false;
            }
            if (mid < cols - 1 && array[maxRow][mid + 1] > array[maxRow][mid]) {
                isPeak = false;
            }

            if (isPeak) {
                return array[maxRow][mid];
            } else if (maxRow > 0 && array[maxRow - 1][mid] > array[maxRow][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // возвращаем -1, если пиковый элемент не найден
    }
}
