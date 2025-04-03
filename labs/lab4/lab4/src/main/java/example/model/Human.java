package example.model;
import java.util.Objects;

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


    @Override
    public String toString() {
        return String.format("%s %s %s (%s)", lastName, firstName, patronymic, sex);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(lastName, human.lastName) &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(patronymic, human.patronymic) &&
                sex == human.sex;
    }


    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, sex);
    }
}

