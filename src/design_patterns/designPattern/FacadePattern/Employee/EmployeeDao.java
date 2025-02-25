package FacadePattern.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    List<Employee> employees;

    public EmployeeDao() {
        employees = new ArrayList<>();
    }

    public void createEmployee(String name, int age) {
        Employee employee = new Employee(name, age);
        employees.add(employee);
    }

    public void allEmployees() {
        System.out.println("List of employees");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.name + " Age: " + employee.age);
        }
    }
}
