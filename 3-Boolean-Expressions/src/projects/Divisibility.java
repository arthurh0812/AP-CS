package projects;

import java.util.Scanner;

public class Divisibility {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int dividend = retrieveInt("Enter the dividend:", "The dividend has to be a numeric value. Enter again:");
        int divisor = retrieveInt("Enter the divisor:", "The divisor has to be a numeric value. Enter again:");

        if (isDivisible(dividend, divisor)) {
            System.out.println(dividend + " is divisible by " + divisor + "!");
        } else {
            System.out.println(dividend + " is not divisible by " + divisor + "!");
        }
    }

    private static boolean isDivisible(int dividend, int divisor) {
        return divisor != 0 && dividend % divisor == 0;
    }

    private static int retrieveInt(String msg, String errMsg) {
        System.out.println(msg);
        while (true) {
            String line = input.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException err) {
                System.out.println(errMsg);
            }
        }
    }
}

