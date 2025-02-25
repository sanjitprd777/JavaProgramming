package SplitWise;

import SplitWise.Expense.ExpenseController;
import SplitWise.Expense.Split.Split;
import SplitWise.Expense.Split.SplitType;
import SplitWise.Group.Group;
import SplitWise.Group.GroupController;
import SplitWise.User.User;
import SplitWise.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user = new User(1, "Sahil");
        User user1 = new User(2, "Sanjit");
        User user2 = new User(3, "Rahul");

        UserController userController = new UserController();
        userController.addUser(user);
        userController.addUser(user1);
        userController.addUser(user2);

        Group group = new Group(1, "300IQ", userController.getUsers());
        GroupController groupController = new GroupController();
        groupController.addGroup(group);

        // Print current expense details and balance sheet.
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Current expense count: " + group.getExpenseController().getExpenses().size());
        for (User usr : group.getUsers()) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Current user: " + usr.getUserName());
            System.out.println("Total expense: " + usr.getUserBalanceSheet().getTotalExpense());
            System.out.println("Total Owe: " + usr.getUserBalanceSheet().getTotalOwe());
            System.out.println("Total GetBack: " + usr.getUserBalanceSheet().getTotalGetBack());
            System.out.println("Expense Balance sheet count: " + usr.getUserBalanceSheet().getFriendsBalance().size());
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        // Add one expense
        ExpenseController expenseController = group.getExpenseController();
        List<Split> splitList = new ArrayList<>();
        splitList.add(new Split(user1, 200.0));
        splitList.add(new Split(user2, 200.0));
        expenseController.addExpense(1, "Sri Vishnu Grand", 600.0, user, 200.0, SplitType.EQUAL, splitList);

        // Print current expense details and balance sheet.
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Current expense count: " + group.getExpenseController().getExpenses().size());
        for (User usr : group.getUsers()) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Current user: " + usr.getUserName());
            System.out.println("Total expense: " + usr.getUserBalanceSheet().getTotalExpense());
            System.out.println("Total Owe: " + usr.getUserBalanceSheet().getTotalOwe());
            System.out.println("Total GetBack: " + usr.getUserBalanceSheet().getTotalGetBack());
            System.out.println("Expense Balance sheet count: " + usr.getUserBalanceSheet().getFriendsBalance().size());
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

    }
}
