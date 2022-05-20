package ap_cs.inheritance_and_polymorphism.employees_lab;

public class NetworkAdministration extends Maintenance {

    public NetworkAdministration(String name) {
        super(name);
    }

    public void work() {
        fixNetworkError();
    }

    public void fixNetworkError() {
        addWorkHours(3);
        System.out.println("Fixing network errors in the Kubernetes cluster");
    }
}
