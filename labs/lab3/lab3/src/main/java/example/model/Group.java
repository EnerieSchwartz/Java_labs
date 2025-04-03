package example.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private Human head;
    private List<Student> students;

    ///constructor
    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>();
    }

    ///add student method
    public void addStudent(Student student) {
        students.add(student);
    }

    ///get group name method
    public String getName() {
        return name;
    }

    ///get students` list method
    public List<Student> getStudents() {
        return students;
    }
}