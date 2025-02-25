package SplitWise.User;

public class User {

    int userId;
    String userName;
    UserBalanceSheet userBalanceSheet;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.userBalanceSheet = new UserBalanceSheet();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }
}
