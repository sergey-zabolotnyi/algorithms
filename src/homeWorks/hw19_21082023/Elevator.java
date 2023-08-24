package homeWorks.hw19_21082023;

import java.util.ArrayList;
import java.util.List;

class Elevator {
    private int currentFloor;
    private char liftName;

    public Elevator(int currentFloor, char liftName) {
        this.currentFloor = currentFloor;
        this.liftName = liftName;
    }

    public char getLiftName() {
        return liftName;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToFloor(int targetFloor) {
        System.out.printf("Лифт %s едет с этажа %d на этаж %d", getLiftName(), currentFloor, targetFloor);
        currentFloor = targetFloor;
    }
}

class ElevatorSystem {
    private List<Elevator> elevators;

    public ElevatorSystem() {
        elevators = new ArrayList<>();
        elevators.add(new Elevator(0, 'A'));  // Лифт A находится на 0 этаже
        elevators.add(new Elevator(8,'B'));  // Лифт B находится на 8 этаже
        elevators.add(new Elevator(7, 'C'));  // Лифт C находится на 7 этаже
    }

    public Elevator requestElevator(int targetFloor) {
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
