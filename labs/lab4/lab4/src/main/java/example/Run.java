package example;

import example.controller.*;
import example.model.*;

public class Run {
    public static void main(String[] args) {
        Human rector = new Human("Oleksandr", "Azyukovsky", "Oleksandrovic", Sex.MALE);
        University uni = UniversityCreator.createUniversity("Dnipro University of technology", rector);

        Human dean = new Human("Iryna", "Udovik", "Mykhailivna", Sex.FEMALE);
        Faculty faculty = FacultyCreator.createFaculty("Faculty of Information Technology", dean);
        UniversityCreator.addFacultyToUniversity(uni, faculty);

        Human headOfDepartment = new Human("Andriy", "Martynenko", "Anatoliyovych", Sex.MALE);
        Department department = DepartmentCreator.createDepartment("Department of Computer Systems Software", headOfDepartment);
        FacultyCreator.addDepartmentToFaculty(faculty, department);

        Human groupHead = new Human("Sophia", "Sholoiko", "Andriyivna", Sex.FEMALE);
        Group group = GroupCreator.createGroup("122-21-2", groupHead);
        DepartmentCreator.addGroupToDepartment(department, group);

        Student stud1 = StudentCreator.createStudent("Savchenko", "Ihor", "Anatoliyovych", Sex.MALE);
        Student stud2 = StudentCreator.createStudent("Taran", "Iryna", "Vitaliivna", Sex.FEMALE);

        GroupCreator.addStudentToGroup(group, stud1);
        GroupCreator.addStudentToGroup(group, stud2);

        System.out.println(uni.getName());
        for (Faculty fac : uni.getFaculties()) {
            System.out.println(fac.getName());
            for (Department dep : fac.getDepartments()) {
                System.out.println(dep.getName());
                for (Group gr : dep.getGroups()) {
                    System.out.println("group " + gr.getName());
                    for (Student stud : gr.getStudents()) {
                        System.out.println("student " + stud.getFullName());
                    }
                }

            }
        }
    }
}