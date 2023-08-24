package homeWorks.hw19_21082023;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem();

        Elevator elevator = elevatorSystem.requestElevator(1);
        if (elevator != null) {
            elevator.moveToFloor(1);
        } else {
            System.out.println("Нет свободного лифта.");
        }
    }
}
