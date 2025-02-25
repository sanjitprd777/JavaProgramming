package FacadePattern.Facade;

import FacadePattern.Employee.EmployeeDao;

public class EmployeeFacade {

    EmployeeDao employeeDao;

    public EmployeeFacade() {
        employeeDao = new EmployeeDao();
    }

    public void insert(String name, int age) {
        employeeDao.createEmployee(name, age);
    }

    public void printEmployees() {
        employeeDao.allEmployees();
    }
}
