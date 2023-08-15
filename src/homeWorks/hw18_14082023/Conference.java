package homeWorks.hw18_14082023;

import java.util.*;

public class Conference {
    //    Максимальная выгода от активностей, второстепенно заполняемость по времени
    //    зал для конференций работает с 9:00 до 17:00
    //    заявки с 9:00 до 13:00 стоят 1 единицу
    //    заявки с 13:00 до 17:00 стоят 2 единицы
    //    заявки на пересечении в большую сторону до 13:00 стоят 1 ед
    //    например с 11 до 14 стоит 1 ед
    //    заявки на пересечении в большую сторону после 13:00 стоят 2 ед
    //    например с 12 до 16 стоит 2 ед
    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(11, 14, 1));
        activities.add(new Activity(12, 16, 2));
        activities.add(new Activity(9, 13, 1));
        activities.add(new Activity(13, 17, 2));


        List<Activity> selectedActivities = selectOptimalActivities(activities);
        int totalValue = calculateTotalValue(selectedActivities);

        System.out.println("Выбранные активности:");
        for (Activity activity : selectedActivities) {
            System.out.println("Начало: " + activity.startTime + " - Конец: " + activity.endTime + " - Стоимость: " + activity.value);
        }
        System.out.println("Общая стоимость: " + totalValue);
    }

    private static int calculateTotalValue(List<Activity> activities) {
        int totalValue = 0;
        for (Activity activity : activities) {
            totalValue += activity.value;
        }
        return totalValue;
    }

    private static List<Activity> selectOptimalActivities(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(a -> a.endTime));

        List<Activity> selectedActivities = new ArrayList<>();
        int currentTime = 9;

        for (Activity activity : activities) {
            if (activity.startTime >= currentTime) {
                selectedActivities.add(activity);
                currentTime = activity.endTime;
            }
        }
        return selectedActivities;

    }
}
class Activity {
    int startTime;
    int endTime;
    int value;

    public Activity(int startTime, int endTime, int value) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.value = value;
    }
}
