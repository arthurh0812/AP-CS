package projects;

import java.util.Scanner;

public class LoopyMethods {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(getFibonacci(0));

        System.out.println(getFibonacci(4));

    }

    public static int getFibonacci(int n) {
        int first = 0, second = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 2) { // initialization of second value
                second = 1;
                continue;
            }
            int prevSecond = second;
            second = first + second;
            first = prevSecond;
        }

        return second;
    }

    public static void printSequence(int n) {
        do {
            System.out.print(n + " ");
            if (isEven(n)) {
                n /= 2;
            } else {
                n *= 3;
                n++;
            }
        } while (n != 1);
        System.out.println(1);
    }

    public static int retrieveUint(Scanner sc) {
        System.out.println("Enter a valid positive integer:");
        while (true) {
            String line = sc.nextLine();
            try {
                int n = Integer.parseInt(line);
                if (n < 0) {
                    throw new NumberFormatException("");
                }
                return n;
            } catch (NumberFormatException err) {
                System.out.println("Please enter a valid positive integer:");
            }
        }
    }

    public static boolean isValid(Long num, int base) {
        int n = num.intValue();
        int sum = 0;
        int pos = 0;
        while (n > 0) {
            pos++;
            int digit = getLastDigit(n, 10);

            if (isEven(pos))
                digit = modifyEven(digit);

            sum += digit;
            n /= base;
        }
        return isDivisibleByTen(sum);
    }

    private static int getLastDigit(int n, int base) {
        return n % base;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static boolean isDivisibleByTen(int n) {
        return n % 10 == 0;
    }

    private static int modifyEven(int digit) {
        digit *= 2;
        if (digit > 9) {
            digit = digit - 9;
        }
        return digit;
    }
}
