package SplitWise.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    List<Group> groups;

    public GroupController() {
        groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
