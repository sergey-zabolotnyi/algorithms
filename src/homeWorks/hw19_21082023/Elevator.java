package homeWorks.hw19_21082023;

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
