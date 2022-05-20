package projects;

import java.util.Scanner;

public class Spawn {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int month = retrieveInt("Please enter month as its numeric value (1 is January, ... 12 is December):", "Enter a valid numeric between 1 and 12 (incl.)");

        if (isSpring(month)) {
            System.out.println("Spring spawning season");
        } else if (isFall(month)) {
            System.out.println("Fall spawning season");
        } else {
            System.out.println("Not spawning season");
        }
    }

    private static int retrieveInt(String msg, String errMsg) {
        System.out.println(msg);
        while (true) {
            String line = input.nextLine();
            try {
                int x = Integer.parseInt(line);
                if (x <= 0) {
                    System.out.println(errMsg);
                    continue;
                } else if (12 < x) {
                    System.out.println(errMsg);
                    continue;
                }
                return x;
            } catch (NumberFormatException err) {
                System.out.println(errMsg);
            }
        }
    }

    private static boolean isSpring(int month) {
        return 3 <= month && month <= 6;
    }

    private static boolean isFall(int month) {
        return 9 <= month && month <= 11;
    }
}
