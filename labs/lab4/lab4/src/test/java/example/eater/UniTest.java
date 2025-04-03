package example.eater;

import example.controller.*;
import example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UniTest {
    @Test
    public void testUniversityJsonSerialization() {

        Human rector = new Human("Oleksandr", "Azyukovsky", "Oleksandrovic", Sex.MALE);
        University oldUniversity = UniversityCreator.createUniversity(
                "Dnipro University of technology",
                rector
        );


        Human dean1 = new Human("Iryna", "Udovik", "Mykhailivna", Sex.FEMALE);
        Faculty faculty1 = FacultyCreator.createFaculty("Faculty of Information Technology", dean1);
        UniversityCreator.addFacultyToUniversity(oldUniversity, faculty1);

        Human dean2 = new Human("Ivan", "Ivanov", "Ivanovic", Sex.MALE);
        Faculty faculty2 = FacultyCreator.createFaculty("Faculty of Economy", dean2);
        UniversityCreator.addFacultyToUniversity(oldUniversity, faculty2);


        Human head1 = new Human("Andriy", "Martynenko","Anatoliyovych", Sex.MALE);
        Department department1 = DepartmentCreator.createDepartment("Department of Computer Systems Software", head1);
        FacultyCreator.addDepartmentToFaculty(faculty1, department1);

        Human head2 = new Human("Mykola", "Shvets", "Ivanovic", Sex.MALE);
        Department department2 = DepartmentCreator.createDepartment("Department of Business Informatics", head2);
        FacultyCreator.addDepartmentToFaculty(faculty1, department2);


        Human head3 = new Human("Maryna", "Lukashenko", "Petrivna", Sex.FEMALE);
        Department department3 = DepartmentCreator.createDepartment("Department of Management", head3);
        FacultyCreator.addDepartmentToFaculty(faculty2, department3);

        Human head4 = new Human("Pavlo", "Shevchenko", "Ivanovic", Sex.MALE);
        Department department4 = DepartmentCreator.createDepartment("Department of Marketing", head4);
        FacultyCreator.addDepartmentToFaculty(faculty2, department4);


        Human groupHead1 = new Human("Sophia","Sholoiko",  "Andriyivna", Sex.FEMALE);
        Group group1 = GroupCreator.createGroup("122-21-2", groupHead1);
        DepartmentCreator.addGroupToDepartment(department1, group1);

        Human groupHead2 = new Human("Savchenko","Ihor",  "Anatoliyovych", Sex.MALE);
        Group group2 = GroupCreator.createGroup("122-21-3", groupHead2);
        DepartmentCreator.addGroupToDepartment(department1, group2);


        Human groupHead3 = new Human("Hanna", "Koval", "Vitaliivna", Sex.FEMALE);
        Group group3 = GroupCreator.createGroup("073-21-1", groupHead3);
        DepartmentCreator.addGroupToDepartment(department2, group3);

        Human groupHead4 = new Human("Daryna", "Levina", "Andriyivna", Sex.FEMALE);
        Group group4 = GroupCreator.createGroup("073-21-2", groupHead4);
        DepartmentCreator.addGroupToDepartment(department2, group4);


        Student student1 = StudentCreator.createStudent("Taran","Iryna",  "Vitaliivna", Sex.FEMALE);
        GroupCreator.addStudentToGroup(group1, student1);

        Student student2 = StudentCreator.createStudent("Alekseenko", "Kateryna", "Andriyivna", Sex.FEMALE);
        GroupCreator.addStudentToGroup(group1, student2);


        Student student3 = StudentCreator.createStudent("Kosach", "Hlib", "Anatoliyovych", Sex.MALE);
        GroupCreator.addStudentToGroup(group2, student3);

        Student student4 = StudentCreator.createStudent("Pototskiy", "Ivan", "Oleksandrovic", Sex.MALE);
        GroupCreator.addStudentToGroup(group2, student4);

        // Serializing into JSON format
        System.out.println("Original university:");
        System.out.println(oldUniversity);
        JsonManager.saveToJson(oldUniversity);
        System.out.println("\nJSON-file was saved.");

        // Deserializing into JSON format
        University newUniversity = JsonManager.loadFromJson();
        System.out.println("\nUpdated uni:");
        System.out.println(newUniversity);


        assertNotNull(newUniversity, "Error: newUniversity is null");
        assertEquals(oldUniversity, newUniversity, "Universities do not match");
        assertEquals(oldUniversity.toString(), newUniversity.toString(), "String representations of universities do not match");


        assertEquals(2, newUniversity.getFaculties().size(), "The number of faculties does not match.");
        assertEquals(2, newUniversity.getFaculties().get(0).getDepartments().size(), "The number of departments at the first faculty does not match.");
        assertEquals(2, newUniversity.getFaculties().get(0).getDepartments().get(0).getGroups().size(), "The number of groups at the first department does not match.");
        assertEquals(2, newUniversity.getFaculties().get(0).getDepartments().get(0).getGroups().get(0).getStudents().size(), "The number of students in the first group does not match");

        System.out.println("\nSuccess! Universities are the same.");
    }


}