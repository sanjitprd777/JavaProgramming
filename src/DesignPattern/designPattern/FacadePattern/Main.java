package FacadePattern;

import FacadePattern.Facade.EmployeeFacade;

public class Main {

    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();
        employeeFacade.insert("Sahil", 24);
        employeeFacade.insert("Sanjit", 25);
        employeeFacade.printEmployees();
    }
}
