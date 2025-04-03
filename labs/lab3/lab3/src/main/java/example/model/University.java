package example.model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private Human rector;
    private List<Faculty> faculties;

    ///constructor
    public University(String name, Human rector) {
        this.name = name;
        this.rector = rector;
        this.faculties = new ArrayList<>();
    }

    ///getters
    public String getName() {
        return name;
    }

    public Human getRector() {
        return rector;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    ///add new faculty method
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}