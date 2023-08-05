package homeWorks.hw16_31072023;

import java.util.EmptyStackException;

public class SpecialStack<T extends Comparable<T>> {
    private Stack<T> mainStack;
    private Stack<T> minStack;

    public SpecialStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }
    public void push(T element) {
        mainStack.push(element);
        if (minStack.isEmpty() || element.compareTo(minStack.peek()) <= 0) minStack.push(element);
    }
    public T pop() {
        if (mainStack.isEmpty()) throw new EmptyStackException();
        T poppedItem = mainStack.pop();
        if (poppedItem.equals(minStack.peek())) minStack.pop();
        return poppedItem;
    }
    public T peek() {
        return mainStack.peek();
    }
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
    public int size() {
        return mainStack.size();
    }
    public void clear() {
        mainStack.clear();
        minStack.clear();
    }
    public T getMin() {
        if (minStack.isEmpty()) throw new EmptyStackException();
        return minStack.peek();
    }
}
