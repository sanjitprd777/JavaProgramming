package SplitWise.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> users;

    public UserController() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
