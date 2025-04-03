package example.controller;

import example.model.*;

public class StudentCreator {
    public static Student createStudent( String lastName, String firstName, String middleName, Sex sex) {
        return new Student(lastName, firstName, middleName, sex);
    }
}