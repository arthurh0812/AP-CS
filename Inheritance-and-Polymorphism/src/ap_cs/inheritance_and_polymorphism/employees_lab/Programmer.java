package ap_cs.inheritance_and_polymorphism.employees_lab;

public class Programmer extends Technology {
    public Programmer(String name) {
        super(name);
    }

    public void work() {
        developAPI();
    }

    public void developAPI() {
        addVacationHours(4);
        System.out.println("Adding features to the API service");
    }
}
