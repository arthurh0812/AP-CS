package instantiating;

public class Person {
    private String name;

    public Person() {
        name = "";
    }

    public Person(String n) {
        name = n;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
