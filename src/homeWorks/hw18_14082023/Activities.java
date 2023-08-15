package homeWorks.hw18_14082023;

import java.util.*;

public class Activities {

    //    У вас есть список активностей, каждая из которых имеет начальное и конечное время. Ваша цель - выбрать
    //    максимальное количество неперекрывающихся активностей.
    //    Напишите функцию maxActivities(activities), которая принимает список активностей. Каждая активность
    //    представлена в виде кортежа (начало, конец). Функция должна вернуть список индексов выбранных активностей.
    //    Функция должна выбирать активности таким образом, чтобы ни одна из выбранных активностей не перекрывалась по
    //    времени, и при этом максимизировать общее количество выбранных активностей.
    //    Пример:
    //    activities = [(1, 4), (3, 5), (0, 6), (5, 7), (3, 8), (5, 9), (6, 10), (8, 11)]
    //    print(maxActivities(activities))  # Результат: [0, 3, 7]
    public static void main(String[] args) {
        List<int[]> activities = new ArrayList<>();
        activities.add(new int[]{1, 4});
        activities.add(new int[]{3, 5});
        activities.add(new int[]{0, 6});
        activities.add(new int[]{5, 7});
        activities.add(new int[]{3, 8});
        activities.add(new int[]{5, 9});
        activities.add(new int[]{6, 10});
        activities.add(new int[]{8, 11});
        activities.add(new int[]{9, 13});
        activities.add(new int[]{12, 14});
        
        Map<Integer, int[]> result = maxActivities(activities);
        for (Map.Entry<Integer, int[]> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        }
    }
    public static Map<Integer, int[]> maxActivities(List<int[]> activities) {
        Map<Integer, int[]> selectedIndices = new HashMap<>();
        activities.sort(Comparator.comparingInt(activity -> activity[1]));
        int lastEndTime = 0;

        for (int i = 0; i < activities.size(); i++) {
            int[] activity = activities.get(i);
            if (activity[0] >= lastEndTime) {
                selectedIndices.put(i,activity);
                lastEndTime = activity[1];
            }
        }
        return selectedIndices;
    }

    
}
