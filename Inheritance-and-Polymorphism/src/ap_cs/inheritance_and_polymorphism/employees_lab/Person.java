package ap_cs.inheritance_and_polymorphism.employees_lab;

public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String name) {
        String[] names = name.split(" ");
        firstName = names[0];
        lastName = names[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
