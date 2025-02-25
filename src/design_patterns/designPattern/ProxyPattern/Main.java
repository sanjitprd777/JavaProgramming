package ProxyPattern;

import ProxyPattern.Employee.Employe;
import ProxyPattern.Employee.EmployeImpl;
import ProxyPattern.Employee.EmployeeType;
import ProxyPattern.Proxy.EmployeProxyImpl;

public class Main {
    public static void main(String[] args) {
        EmployeImpl employeAdmin = new EmployeImpl(EmployeeType.ADMIN);
        EmployeProxyImpl employeProxy = new EmployeProxyImpl(employeAdmin);

        employeProxy.createEmployee();
        employeProxy.deleteEmployee();
        employeProxy.getEmployee();

        System.out.println();

        EmployeImpl employeUser = new EmployeImpl(EmployeeType.USER);
        employeProxy = new EmployeProxyImpl(employeUser);

        employeProxy.createEmployee();
        employeProxy.deleteEmployee();
        employeProxy.getEmployee();

    }
}
