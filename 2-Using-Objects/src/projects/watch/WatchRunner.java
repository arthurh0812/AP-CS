package projects.watch;

public class WatchRunner {
    public static void main(String[] args) {
        Watch w = new Watch(7, 45, 23);
        System.out.println(w.getTime());

        w.changeTime(10);
        System.out.println(w.getTime());

        w.changeTime(4, 30);
        System.out.println(w.getTime());

        if (w.isDay()) {
            System.out.println("It is day!");
        } else {
            System.out.println("It is night!");
        }
    }
}
