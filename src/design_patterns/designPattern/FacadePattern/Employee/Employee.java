package FacadePattern.Employee;

public class Employee {

    static int id = 0;
    String name;
    int age;

    public Employee(String name, int age) {
        id++;
        this.name = name;
        this.age = age;
    }
}
