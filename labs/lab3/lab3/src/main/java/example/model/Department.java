package example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups;

    ///constructor
    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.groups = new ArrayList<>();
    }

    ///getters
    public String getName() {
        return name;
    }


    public Human getHead() {
        return head;
    }


    public List<Group> getGroups() {
        return groups;
    }


    public void addGroup(Group group) {
        groups.add(group);
    }
}