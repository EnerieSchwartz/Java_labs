package example.database;

import example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/students"; /// JDBC URL for connecting to PostgreSQL
    private static final String USER = "user";
    private static final String PASSWORD = "password";


    public static void initDatabase() {
        System.out.println("DB is connected");
    }


    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),

                        resultSet.getString("patronymic"),

                        resultSet.getDate("birth_date").toString(),
                        resultSet.getString("record_book_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
