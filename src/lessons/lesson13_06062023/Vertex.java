package lessons.lesson13_06062023;

public class Vertex {
    private int number;
    private int value;

    public Vertex(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vertex " + number + ": value=" + value;
    }
}
