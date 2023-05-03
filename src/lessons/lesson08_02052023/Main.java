package lessons.lesson08_02052023;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] number = {3,4,5};
//        String s = "";
//        for (int i = 0; i < number.length; i++) {
//            s = s+number[i];
//
//        }
//        int s = 0;
//        for (int i = 0; i < number.length; i++) {
//            s = s*10+number[i];
//        }
//        s+=1;
//        System.out.println(s);
//        int temp = s;
//        int length = 0;
//        while (temp !=0){
//            length++;
//            temp = temp/10;
//        }
//        System.out.println(length);
//        int[] number1 = new int[length];
//        for (int i = length-1; i >= 0; i--) {
//            number1[i] = s%10;
//            s=s/10;
//        }
//        System.out.println(Arrays.toString(number1));
//        ArrayList<Integer> number1 = new ArrayList<>();
//        while (s>0){
//            number1.add(0,s%10);
//            s/=10;
//        }
//        System.out.println(number1);
        int num = Arrays.stream(number).reduce(0,(n,m)->n=n*10+m);
        num+=1;
        int[] number1 = Integer.toString(num).chars().map(Character::getNumericValue).toArray();
        System.out.println(Arrays.toString(number1));
        
        System.out.println(fibonacci(46));
    }
    public static long fibonacci(int n){
        if(n<2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
