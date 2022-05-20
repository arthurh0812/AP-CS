package ap_cs.inheritance_and_polymorphism.employees_lab;

// Technology Department
public abstract class Technology extends Employee {
    private final double ADDITIONAL_HOURLY_WAGE = 15;

    public Technology(String name) {
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
