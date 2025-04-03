package example.controller;

import example.model.*;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human dean) {
        return new Faculty(name, dean); ///створюэмо факультет з назвою та деканом
    }

    public static void addDepartmentToFaculty(Faculty faculty, Department department) {
        faculty.addDepartment(department);
    }
}