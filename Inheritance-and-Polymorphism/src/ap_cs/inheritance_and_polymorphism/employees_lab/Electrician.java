package ap_cs.inheritance_and_polymorphism.employees_lab;

public class Electrician extends Technology {
    public Electrician(String name) {
        super(name);
    }

    public void work() {
        implementCircuit();
    }

    public void implementCircuit() {
        addWorkHours(2);
        System.out.println("Adding electric circuit to a hardware component");
    }
}
