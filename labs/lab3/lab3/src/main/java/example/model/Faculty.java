package example.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private Human head;
    private List<Department> departments;


    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
        this.departments = new ArrayList<>(); ///створюємо список кафедр (поки що пустий)
    }

    ///group name getter
    public String getName() {
        return name;
    }

    ///dean getter
    public Human getHead() {
        return head;
    }

    ///gepartments` list getter`
    public List<Department> getDepartments() {
        return departments;
    }


    public void addDepartment(Department department) {
        departments.add(department);
    }
}