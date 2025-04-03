package example.model;

public class Student extends Human {
    ///constructor
    public Student(String lastName, String firstName, String patronymic, Sex sex) {
        super(lastName, firstName, patronymic, sex);
    }

    ///getter
    public String getFullName() {
        return getLastName() + " " + getFirstName() + " " + getPatronymic(); ///формат: "Прізвище Ім'я По-батькові"
    }
}