package homeWorks.hw19_21082023;

import java.util.ArrayList;
import java.util.List;

public class Main {

//    Вызов лифта: В доме два лифта. Реализовать алгоритм отправки наиближайшего на вызывающий этаж.
//    Алгоритм будет применяться в домах разной этажности.
//    Алгоритм будет применяться в домах с количеством > 2 лифтов
//    Пример: в доме 19 этажей, работают лифт А и лифт В
//    лифт А находиться на 0 этаже
//    лифт В находиться на 8 этаже
//    лифт C находиться на 7 этаже
//    на вход: 1, отправляем лифт А

    public static void main(String[] args) {
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator(0, 'A'));  // Лифт A находится на 0 этаже
        elevators.add(new Elevator(8,'B'));  // Лифт B находится на 8 этаже
        elevators.add(new Elevator(7, 'C'));  // Лифт C находится на 7 этаже

        int targetFloor = 1; // на какой этаж вызов лифта
        Elevator elevator = requestElevator(elevators, targetFloor);
        elevator.moveToFloor(targetFloor);
    }
    public static Elevator requestElevator(List<Elevator> elevators, int targetFloor) {
        Elevator nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - targetFloor);
            if (distance < minDistance) {
                nearestElevator = elevator;
                minDistance = distance;
            }
        }
        return nearestElevator;
    }
}
