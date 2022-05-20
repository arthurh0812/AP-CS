package ap_cs.inheritance_and_polymorphism.employees_lab;

public class Tester {
    public static void main(String[] args) {
        Programmer nick = new Programmer("Nick Stephens");

        System.out.println(nick);

        nick.addWorkHours(250);
        nick.addVacationHours(1);
        System.out.println(nick.payDay());

        NetworkAdministration kevin = new NetworkAdministration("Kevin Durant");
        kevin.addWorkHours(200);
        kevin.addVacationHours(300);
        System.out.println(kevin.payDay());

        kevin.getRaise(0.25);
        kevin.addWorkHours(200);
        System.out.println(kevin.payDay());

        Employee[] workers = new Employee[]{nick, kevin};

        for (Employee e : workers) {
            e.work();
        }


    }
}
