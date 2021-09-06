/* Program ChangeMachine.java
  ChangeMachine functions like a money change machine. It will ask for a floating-point input value given by the
  standard input. The program will then calculate the stack of individual bill sizes that make up the given money
  amount in dollars.
 */
package ap_cs.primitives.projects;

import java.io.PrintStream;
import java.util.Scanner;

public class ChangeMachine {
    private static int rest = 0;
    private static boolean exit = false;

    public static void exit() {
        exit = true;
    }
    public static boolean shouldExit() {
        return exit;
    }

    private static final int CENTS_PER_DOLLAR = 100;
    public static int calcTotalCents(double total) {
        return (int) (total * CENTS_PER_DOLLAR);
    }

    public static void setRest(int rest) {
        ChangeMachine.rest = rest;
    }

    public static int getRest() {
        return ChangeMachine.rest;
    }

    public static void main(String[] args) {
        Currency c = retrieveCurrency(args);
        while (!shouldExit()) {
            runChange(c);
        }
        closeIO();
    }

    private static final Scanner input = new Scanner(System.in);
    private static final PrintStream output = System.out;

    private static void closeIO() {
        input.close();
        output.close();
    }

    private static final String exitMsg = "exit";

    public static Currency retrieveCurrency(String[] args) {
        if (args.length <= 1) {
            return Currency.USD;
        }
        return Currency.valueOf(args[0].toUpperCase());
    }

    public static double retrieveDouble(String msg) {
        output.println(msg);
        while (true) {
            String line = input.nextLine();
            if (line.equalsIgnoreCase(exitMsg)) {
                exit();
                return 0;
            }
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException err) {
                output.printf("'%s' is an inappropriate value. Please try again:\n", line);
            }
        }
    }
    // cents per bill size
    private static final Integer[] relations = {10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
    // bill size types
    private static final String[] sizes = {"hundreds", "fifties", "twenties", "tens", "fives", "dollars", "quarters", "dimes", "nickels", "pennies"};

    public static void runChange(Currency c) {
        double total = retrieveDouble(String.format("Enter amount in %s:", c.getName()));
        if (exit) {
            return;
        }
        int totalCents = calcTotalCents(total);
        setRest(totalCents);
        ChangeStack stack = new ChangeStack();
        fillStack(stack);
        printStack(stack);
    }

    // calculate returns the maximum amount of bills that fit into the current state of 'rest'
    // The calculation happens based on the given cents-per-billSize relation.
    // The state of 'rest' is then set to the newly calculated rest (in cents).
    public static int calculate(int relation) {
        int cents = getRest();
        int count = cents / relation;
        setRest(cents % relation);
        return count;
    }

    // fillStack assigns each individual bill size its calculated amount inside the money stack.
    // The calculation is based on the total amount of cents that were the initial input.
    public static void fillStack(ChangeStack stack) {
        for (int idx = 0; idx < sizes.length; idx++) {
            int relation = relations[idx];
            int count = calculate(relation);
            if (count > 0) {
                stack.putCount(sizes[idx], count);
            }
        }
    }

    // printStack uses the given stack of bill sizes and their corresponding counts to loop through them and print them
    // to the standard output.
    public static void printStack(ChangeStack stack) {
        for (int idx = 0; idx < sizes.length; idx++) {
            String billSize = sizes[idx];
            if (stack.hasCount(billSize)) {
                int count = stack.getCount(sizes[idx]);
                output.printf("%d %s\n", count, billSize);
            }
        }
    }
}