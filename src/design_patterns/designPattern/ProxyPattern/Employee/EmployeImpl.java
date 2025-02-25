package ProxyPattern.Employee;

public class EmployeImpl implements Employe {

    EmployeeType employeeType;

    public EmployeImpl(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public void createEmployee() {
        System.out.println("Successfully created user!");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Successfully deleted user!");
    }

    @Override
    public void getEmployee() {
        System.out.println("Successfully returned user!");
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
