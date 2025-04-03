package example;

import example.database.DatabaseManager;
import example.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.initDatabase();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt(); ///getting data

        List<Student> allStudents = DatabaseManager.getAllStudents();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Student> filteredStudents = allStudents.stream()
                .filter(student -> {
                    try {
                        LocalDate birthDate = LocalDate.parse(student.getBirthDate(), formatter);
                        return birthDate.getMonthValue() == month;
                    } catch (Exception e) {
                        System.err.println("Error while parsing data: " + student.getBirthDate());
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (filteredStudents.isEmpty()) {
            System.out.println("No match");
        } else {
            System.out.println("Data was successfully fetched:");
            filteredStudents.forEach(System.out::println); ///виводимо всіх знайдених
        }
        scanner.close();
    }
}