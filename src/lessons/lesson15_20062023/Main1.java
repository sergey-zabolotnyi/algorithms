package lessons.lesson15_20062023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee>{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.age, o.age);
    }
}
class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class Main1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30));
        employees.add(new Employee("Alice", 25));
        employees.add(new Employee("Bob", 35));

        Collections.sort(employees);
        System.out.println("Сортировка по возрасту Comparable: ");
        for (Employee emp : employees) System.out.println(emp);

        Comparator<Employee> naneComparatorReverse = new NameComparator();
        Collections.sort(employees, naneComparatorReverse);
        System.out.println("Сортировка по возрасту Comparator: ");
        for (Employee emp : employees) System.out.println(emp);
    }
}
