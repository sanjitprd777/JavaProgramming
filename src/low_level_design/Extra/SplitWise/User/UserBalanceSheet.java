package SplitWise.User;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {

    Map<User, Balance> friendsBalance;
    Double totalExpense;
    Double totalOwe;
    Double totalGetBack;

    public UserBalanceSheet() {
        friendsBalance = new HashMap<>();
        totalExpense = 0.0;
        totalOwe = 0.0;
        totalGetBack = 0.0;
    }

    public Map<User, Balance> getFriendsBalance() {
        return friendsBalance;
    }

    public void setFriendsBalance(Map<User, Balance> friendsBalance) {
        this.friendsBalance = friendsBalance;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(Double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public Double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(Double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
