package lessons.lesson17_31072023;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    public int count;
    public ArrayList<T> items;

    public Stack(){
        this.count = 0;
        this.items = new ArrayList<>();
    }

    public void push(T element){
        this.items.add(element);
        this.count++;
    }

    public T pop(){
        if (this.count==0){
            throw new EmptyStackException();
        }
        T deleteItem = this.items.remove(this.count-1);
        this.count--;
        return deleteItem;
    }
    public T peek() {
        if (this.count == 0) {
            throw new EmptyStackException();
        }
        return this.items.get(this.count - 1);
    }
    public boolean isEmpty() {
        return this.count == 0;
    }
    public int size() {
        return this.count;
    }
    public void clear() {
        this.items.clear();
        this.count = 0;
    }
}