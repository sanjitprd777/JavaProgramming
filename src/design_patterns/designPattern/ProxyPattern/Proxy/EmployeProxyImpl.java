package ProxyPattern.Proxy;

import ProxyPattern.Employee.Employe;
import ProxyPattern.Employee.EmployeImpl;
import ProxyPattern.Employee.EmployeeType;

public class EmployeProxyImpl implements Employe {

    EmployeImpl employe;

    public EmployeProxyImpl(EmployeImpl employe) {
        this.employe = employe;
    }

    @Override
    public void createEmployee() {
        if (EmployeeType.ADMIN == employe.getEmployeeType()) {
            employe.createEmployee();
        }
        else {
            System.out.println("You don't have enough permission to fulfill this task.");
        }
    }

    @Override
    public void deleteEmployee() {
        if (EmployeeType.ADMIN == employe.getEmployeeType()) {
            employe.deleteEmployee();
        }
        else {
            System.out.println("You don't have enough permission to fulfill this task.");
        }
    }

    @Override
    public void getEmployee() {
        if (EmployeeType.ADMIN == employe.getEmployeeType() || EmployeeType.USER == employe.getEmployeeType()) {
            employe.getEmployee();
        }
        else {
            System.out.println("You don't have enough permission to fulfill this task.");
        }
    }
}
