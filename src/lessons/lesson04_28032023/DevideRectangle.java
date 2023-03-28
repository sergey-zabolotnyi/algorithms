package lessons.lesson04_28032023;

public class DevideRectangle {
    public static void main(String[] args) {
        divideRectangleToSquares(1680, 640);
    }

    public static void divideRectangleToSquares(int width, int height) {
        // если ширина и высота равны, то это уже квадрат, выводим его размер
        if (width == height) {
            System.out.println("Квадрат со стороной " + width);
        } else {
            // находим меньшую сторону и делим прямоугольник на квадраты такого размера
            int smallerSide = Math.min(width, height);
            int largerSide = Math.max(width, height);
            int squareSize = smallerSide;
            int remainingSize = largerSide - squareSize;
            System.out.println("Квадрат со стороной " + squareSize);

            // вызываем функцию рекурсивно для оставшейся части прямоугольника
            divideRectangleToSquares(remainingSize, squareSize);
        }
    }

}
