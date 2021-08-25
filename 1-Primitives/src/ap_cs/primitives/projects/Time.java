package ap_cs.primitives.projects;

public class Time {
    private static int totalMinutes = 0;
    private static int days = 0;
    private static int hours = 0;
    private static int minutes = 0;

    public static void setTotalMinutes(int totalMinutes) {
        Time.totalMinutes = totalMinutes;
    }

    public static void setDays(int days) {
        Time.days = days;
    }

    public static void setHours(int hours) {
        Time.hours = hours;
    }

    public static void setMinutes(int minutes) {
        Time.minutes = minutes;
    }

    public static void main(String[] args) {
        setTotalMinutes(3800);

        setDays(calcDays(totalMinutes));
        setHours(remainingHours(totalMinutes));
        setMinutes(remainingMinutes(totalMinutes));

        printTime();
    }

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public static int calcDays(int minutes) {
        hours = calcHours(minutes);
        return hours / HOURS_PER_DAY;
    }

    public static int calcHours(int minutes) {
        return minutes / MINUTES_PER_HOUR;
    }

    public static int remainingHours(int minutes) {
        int hours = calcHours(minutes);
        return hours % HOURS_PER_DAY;
    }

    public static int remainingMinutes(int minutes) {
        return minutes % MINUTES_PER_HOUR;
    }

    public static void printTime() {
        String msg = String.format("%s minutes is %d days, %d hours and %d minutes", totalMinutes, days, hours, minutes);
        System.out.println(msg);
    }
}
