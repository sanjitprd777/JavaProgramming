package MapReduce;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class MapReduceComplexObject {

    static class Employee {
        int id;
        String name;
        double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        static List<Employee> getEmployee() {
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(1, "a", 100));
            employees.add(new Employee(2, "b", 200));
            employees.add(new Employee(3, "c", 300));
            employees.add(new Employee(4, "Ad", 400));
            return employees;
        }

        double getSalary() {
            return this.salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployee();

        // Print average salary of all employees
        double avgSalary = employees.stream().map(e -> e.getSalary()).mapToDouble(s -> s).average().getAsDouble();
        System.out.println("Average salary: " + avgSalary);

        // Print the average salary of employees whose name starts with a or A.
        double avgSalWitha = employees.stream().filter(e -> e.name.startsWith("a")).map(Employee::getSalary).mapToDouble(s -> s).average().getAsDouble();
        System.out.println(avgSalWitha);
    }
}
