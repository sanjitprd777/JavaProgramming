package SplitWise;

import SplitWise.Group.Group;
import SplitWise.Group.GroupController;
import SplitWise.User.User;
import SplitWise.User.UserController;

public class SplitWise {
    GroupController groupController;
    UserController userController;

    public SplitWise() {
        groupController = new GroupController();
        userController = new UserController();
    }

    public void createGroup(Group group) {
        groupController.addGroup(group);
    }

    public void createUser(User user) {
        userController.addUser(user);
    }

    public GroupController getGroupController() {
        return groupController;
    }

    public void setGroupController(GroupController groupController) {
        this.groupController = groupController;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
