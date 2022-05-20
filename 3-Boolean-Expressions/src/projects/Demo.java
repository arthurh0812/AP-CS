package projects;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Demo {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double n = retrieveDouble();
        if (0 < n) {
            System.out.println("The number is positive!");
        } else if (n < 0){
            System.out.println("The number is negative!");
        } else {
            System.out.println("The number is neither positive nor negative!");
        }
    }

    public static double retrieveDouble() {
        System.out.println("Enter a numeric value:");
        while (true) {
            String line = input.nextLine();
            try {
                return Double.parseDouble(line);
            } catch (NullPointerException | NumberFormatException err) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
