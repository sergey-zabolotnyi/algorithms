package lessons.lesson15_20062023;

import java.util.*;

class Employee1 {
    private static int autoIncr = 0;
    private int id;
    private String name;
    private int age;

    public Employee1(String name, int age) {
        this.id = ++autoIncr;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return id == employee1.id && age == employee1.age && Objects.equals(name, employee1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<Employee1> employees1 = new ArrayList<>();
        employees1.add(new Employee1("John", 30));
        employees1.add(new Employee1("Alice", 25));
        employees1.add(new Employee1("Bob", 35));
        employees1.add(new Employee1("Alice", 28));
        employees1.add(new Employee1("John", 30));
        employees1.add(new Employee1("Alice", 28));
        employees1.add(new Employee1("Bob", 35));

        Comparator<Employee1> nameCompare = Comparator.comparing(Employee1::getName);
        Comparator<Employee1> ageCompare = Comparator.comparing(Employee1::getAge);
        Comparator<Employee1> idCompare = Comparator.comparing(Employee1::getId);

        Collections.sort(employees1,nameCompare.thenComparing(ageCompare.thenComparing(idCompare)));
        for (Employee1 emp : employees1) System.out.println(emp);
    }

}

