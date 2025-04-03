package example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }


    @Override
    public String toString() {
        StringBuilder facultiesString = new StringBuilder();
        for (Faculty faculty : faculties) {
            facultiesString.append(faculty.toString()).append("\n");
        }
        return "University{name='" + name + "', rector=" + rector + ", faculties=\n" + facultiesString.toString() + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(rector, that.rector) &&
                Objects.equals(faculties, that.faculties);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, rector, faculties);
    }
}
