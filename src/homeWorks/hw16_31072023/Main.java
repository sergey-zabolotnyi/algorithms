package homeWorks.hw16_31072023;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        1. Создать класс Emploee
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Manager", 1500, "sales"),
                new Employee("Alice", "Developer", 1200, "development"),
                new Employee("Bob", "Marketer", 1000, "marketing"),
                new Employee("Eve", "Developer", 1400, "development"),
                new Employee("Dan", "Manager", 1800, "sales"),
                new Employee("Carol", "Marketer", 1201, "marketing"));

//        2. Сгрупировать сотрудников по должности
        Map<String, List<Employee>> employeePosition = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        for (Map.Entry<String,List<Employee>> entry : employeePosition.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("==============");
//        3. Вычислить среднюю зарплату всех сотрудников
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println(averageSalary);
        System.out.println("==============");
//        4. Получить список сотрудников с зп > 1000
        List<Employee> employees1000 = employees.stream()
                .filter(employee -> employee.getSalary() >= 1500).toList();
        for (Employee employee : employees1000){
            System.out.println(employee);
        }
        System.out.println("==============");
//        5. Получить список сотрудников из отдела маркетинг и увеличить зп на 20%
        List<Employee> employees20Salary = employees.stream()
                .filter(employee -> "marketing".equals(employee.getDepartment()))
                .map(employee -> {
                    double bonus15 = employee.getSalary() * 1.2;
                    return new Employee(employee.getName(), employee.getPosition(), bonus15, employee.getDepartment());
                }).toList();
        for (Employee employee : employees20Salary){
            System.out.println(employee);
        }
        System.out.println("==============");
//        6. Получить сотрудника с самой низкой зп

        Employee employeeMin = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(employeeMin);
        System.out.println("==============");
//        7. Получите сотрудников из всех отделов с зп больше 1200
        Map<String,List<Employee>> employees1 = employees.stream()
                .filter(employee -> employee.getSalary()>1000)
                .collect(Collectors.groupingBy(Employee::getDepartment));
        for (Map.Entry<String,List<Employee>> entry : employees1.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
class Employee {
    private String name;
    private String position;
    private double salary;
    private String department;

    public Employee(String name, String position, double salary, String department) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
