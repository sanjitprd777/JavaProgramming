package low_level_design.Extra.SplitWise.Expense;

import SplitWise.Expense.Split.SplitType;
import SplitWise.User.Balance;
import SplitWise.User.BalanceType;
import SplitWise.User.User;
import SplitWise.User.UserBalanceSheet;

import java.util.*;

public class ExpenseController {

    List<Expense> expenses;

    public ExpenseController() {
        expenses = new ArrayList<>();
    }

    public void addExpense (int expenseId, String description, Double totalAmount,
                            User paidByUser, Double amoutPaidByUser, SplitType splitType, List<Split> splits) {
        if (!verifyExpense(splitType, splits, amoutPaidByUser, totalAmount)) {
            System.out.println("Check the split amount again!");
            return;
        }
//        Expense tempExpense = new Expense.ExpenseBuilder()
//                .expenseId()
//                .description()
//                .build();
        Expense expense = new Expense(expenseId, description, totalAmount, paidByUser, splitType, splits);
        expenses.add(expense);
        updateBalanceSheet(paidByUser, splits, totalAmount);
    }

    boolean verifyExpense(SplitType splitType, List<Split> splits, Double amountPaid, Double totalAmount) {
        Double amount = 0.0;
        for (Split split : splits) {
            amount = amount + split.getAmount();
        }
        if (!amount.equals(totalAmount - amountPaid))
            return false;

        if (SplitType.EQUAL.equals(splitType)) {
            for (Split split : splits) {
                if (!split.getAmount().equals(amountPaid)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void updateBalanceSheet(User paidByUser, List<Split> splits, Double amount) {
        // Calculate amount paid by payee user.
        double amountPaid = 0.0;
        for (Split split : splits) {
            amountPaid = amountPaid + split.getAmount();
        }
        amountPaid = amount - amountPaid;

        // Update balance sheet of payee and users will give money.
        UserBalanceSheet payee = paidByUser.getUserBalanceSheet();
        payee.setTotalExpense(payee.getTotalExpense() + amountPaid);
        payee.setTotalGetBack(payee.getTotalGetBack() + amountPaid);

        for (Split split : splits) {
            Double toPay = split.getAmount();
            if (payee.getFriendsBalance().containsKey(split.getUser())) {
                toPay = toPay + payee.getFriendsBalance().get(split.getUser()).getAmount();
            }
            Balance balance = new Balance(toPay, BalanceType.OWE);
            payee.getFriendsBalance().put(split.getUser(), balance);

            // Update balance sheet of givers.
            UserBalanceSheet giver = split.getUser().getUserBalanceSheet();
            giver.setTotalExpense(giver.getTotalExpense() + split.getAmount());
            giver.setTotalOwe(giver.getTotalOwe() + split.getAmount());

            Double toGive = split.getAmount();
            if (giver.getFriendsBalance().containsKey(paidByUser)) {
                toGive = toGive + giver.getFriendsBalance().get(paidByUser).getAmount();
            }
            balance = new Balance(toGive, BalanceType.GIVE);
            giver.getFriendsBalance().put(paidByUser, balance);
        }
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
