package while_loops;

public class Main {

    public static void main(String[] args) {
        q5();
        q6();
        countThis();
    }

    private static void q5() {
        int i = 0;
        while (i < 5) {
            System.out.print(i);
            i++;
        }

        // Output:
        // 01234
    }

    private static void q6() {
        int i = 1;
        while (i < 12) {
            System.out.print("ring ");
            i = i * 2;
        }

        // Output:
        // ring ring ring ring
    }

    private static void countThis() {
        int i = 1;
        while (i <= 5) {
            // to-do: 1. print i
            System.out.print(i);
            // to==
        }
    }
}
