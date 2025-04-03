package example.model;

public class Human {
    protected String lastName;
    protected String firstName;
    protected String patronymic;
    protected Sex sex;

    ///constructor
    public Human(String firstName, String lastName, String patronymic, Sex sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    ///getters
    public String getLastName() {
        return lastName;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getPatronymic() {
        return patronymic;
    }


    public Sex getSex() {
        return sex;
    }


    public String getFullName() {
        return lastName + " " + firstName + " " + patronymic; ///класичний український формат
    }
}