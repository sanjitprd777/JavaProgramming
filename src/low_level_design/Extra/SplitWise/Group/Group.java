package SplitWise.Group;

import SplitWise.Expense.ExpenseController;
import SplitWise.User.User;

import java.util.List;

public class Group {

    int groupId;
    String groupName;
    List<User> users;
    ExpenseController expenseController;

    public Group(int groupId, String groupName, List<User> users) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.users = users;
        this.expenseController = new ExpenseController();
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }

    public void setExpenseController(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }
}
