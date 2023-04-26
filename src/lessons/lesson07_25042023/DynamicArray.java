package lessons.lesson07_25042023;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int count;
    private int size;

    public DynamicArray() {
        array = new int[2];
        count = 0;
        size = 1;
    }
    // добавление элемента в конец массива
    public void add(int data){
        // проверим нужно ли расширять массив
        if(count == size){
            increaseArray(); // делаем массив в 2 раза больше
        }
        array[count] = data;
        count++;
    }
    // Увеличение массива в 2 раза
    private void increaseArray() {
        size = size * 2;
        int[] temp = new int[size];
        for (int i = 0; i < count; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    /**
     * Добавление элемента в конец массива
     * @param data значение, которое нужно добавить в массив
     * @param index
     */
    // добавление элемента в ячейку с указанным индексом
    public void add(int data, int index){
        if(index < 0 || index > size){
            System.out.println("Index out of bounds!!!");
            return;
        }
        if(count == size){
            increaseArray();
        }
        for(int i = count - 1; i >=index; i--){
            array[i + 1] = array[i];
        }
    }
    public void printArray(){
        System.out.println(Arrays.toString(array) + ", count = " + count + ", size = " +size);
    }
    public void remove(){
        if(count > 0){
            array[count - 1] = 0;
            count--;
        }
    }
    public void remove(int index){

    }
}
