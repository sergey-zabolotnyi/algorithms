package lessons.lesson09_09052023;

public class ArrayStack {
    private int[] array;
    private int count;
    public ArrayStack(int size){
        array = new int[size];
        count = 0;
    }
    public void push(int value){
        if( count == array.length){
            System.out.println("Stack is full!");
            return;
        }
        array[count] = value;
        count++;
    }
    public int pop(){
        if(count == 0){
            System.out.println("Stack is full!");
            return -1;
        }
        count--;
       return 0;
    }
    public boolean isEmpty(){
        return count == 0;
    }

}
