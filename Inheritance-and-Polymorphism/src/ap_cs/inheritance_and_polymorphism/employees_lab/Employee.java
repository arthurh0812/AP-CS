package ap_cs.inheritance_and_polymorphism.employees_lab;

import java.util.Date;

public abstract class Employee extends Person {
    public static final double BASE_HOURLY_WAGE = 15;

    private final Date dateEmployed;
    private int workHours;
    public int getWorkHours() {
        return workHours;
    }
    private int vacationHours;

    private int totalWorkHours;
    private int totalVacationHours;

    private double hourlyWage;
    private double totalPaid;
    public void increaseTotalPaid(double amount) {
        if (0 < amount) {
            totalPaid += amount;
        }
    }

    public abstract void work();

    public Employee(String name) {
        super(name);
        dateEmployed = new Date();
    }

    public String payDay() {
        if (workHours > 40) {
            totalPaid += 40 * BASE_HOURLY_WAGE + (workHours - 40) * (BASE_HOURLY_WAGE * 1.5);
        } else {
            totalPaid += workHours * BASE_HOURLY_WAGE;
        }
        updateHours();
        return payCheck();
    }

    public void updateHours() {
        totalWorkHours += workHours;
        totalVacationHours += vacationHours;
        workHours = 0;
        vacationHours = 0;
    }

    public void addWorkHours(int h) {
        if (h > 0) {
            workHours += h;
        }
    }

    public void addVacationHours(int h) {
        if (h > 0) {
            vacationHours += h;
        }
    }

    public void getRaise(double percentage) {
        if (0 < percentage && percentage < 0.25) {
            hourlyWage += (hourlyWage * percentage);
        }
    }

    public void increaseHourlyWage(double amount) {
        if (0 < amount && amount <= 100) {
            hourlyWage += amount;
        }
    }

    public String payCheck() {
        return "Hours worked: " + totalWorkHours + "h\n"
                + "Vacation taken: " + totalVacationHours + "h\n"
                + "Amount paid: $" + totalPaid + "\n";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + super.toString() +
                ", dateEmployed=" + dateEmployed +
                ", hourlyWage=" + hourlyWage +
                ", totalWorkHours=" + totalWorkHours +
                ", totalVacationHours=" + totalVacationHours +
                ", totalPaid=" + totalPaid +
                '}';
    }
}
