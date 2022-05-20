package ap_cs.inheritance_and_polymorphism.employees_lab;

// Maintenance Department
public abstract class Maintenance extends Employee {
    private static final double ADDITIONAL_HOURLY_WAGE = 10;

    public Maintenance(String name) {
        super(name);
        increaseHourlyWage(ADDITIONAL_HOURLY_WAGE);
    }

    public String payDay() {
        int workHours = getWorkHours();
        if (workHours > 40) {
            increaseTotalPaid(workHours * (BASE_HOURLY_WAGE + ADDITIONAL_HOURLY_WAGE) + (workHours - 40) * (BASE_HOURLY_WAGE + ADDITIONAL_HOURLY_WAGE) * 1.5);
        } else {
            increaseTotalPaid(workHours * (BASE_HOURLY_WAGE + ADDITIONAL_HOURLY_WAGE));
        }
        updateHours();
        return payCheck();
    }
}
