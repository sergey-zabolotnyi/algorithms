package lessons.lesson04_28032023;

public class Main {
    public static void main(String[] args) {
        int[] array = {2,5,6,};
        System.out.println(sum(array,0));

    }
    private static int sum(int[] array, int k){
        if(k == array.length - 1){
        return array[k];
        }
        return array[k] + sum(array, k + 1);
    }
    //Рекурсивная реализация бинарного поиска
    private static int binarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(target == nums[mid]){
            return mid;
        }else if (target > nums[mid]){
            return binarySearch(nums, left, mid -1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }
}
