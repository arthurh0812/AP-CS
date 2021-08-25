/* Program ChangeMachine.java
  ChangeMachine functions like a money change machine. It will ask for a floating-point input value given by the
  standard input. The program will then calculate the stack of individual bill sizes that make up the given money
  amount in dollars.
 */
package ap_cs.primitives.projects;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChangeMachine {
    private static int rest = 0;
    private static boolean exit = false;

    public static void exit() {
        exit = true;
    }

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
        while (!exit) {
            runChange();
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

    private static final int CENTS_PER_HUNDREDS = 10000;
    private static final String SIZE_HUNDREDS = "hundreds";
    private static final int CENTS_PER_FIFTY = 5000;
    private static final String SIZE_FIFTIES = "fifties";
    private static final int CENTS_PER_TWENTY = 2000;
    private static final String SIZE_TWENTIES = "twenties";
    private static final int CENTS_PER_TEN = 1000;
    private static final String SIZE_TENS = "tens";
    private static final int CENTS_PER_FIVE = 500;
    private static final String SIZE_FIVES = "fives";
    private static final int CENTS_PER_DOLLAR = 100;
    private static final String SIZE_DOLLARS = "dollars";
    private static final int CENTS_PER_QUARTER = 25;
    private static final String SIZE_QUARTERS = "quarters";
    private static final int CENTS_PER_DIME = 10;
    private static final String SIZE_DIMES = "dimes";
    private static final int CENTS_PER_PENNY = 1;
    private static final String SIZE_PENNIES = "pennies";

    // bill size type -> cents per bill size
    private static final Map<String, Integer> relations = Map.of(
            SIZE_HUNDREDS, CENTS_PER_HUNDREDS,
            SIZE_FIFTIES, CENTS_PER_FIFTY,
            SIZE_TWENTIES, CENTS_PER_TWENTY,
            SIZE_TENS, CENTS_PER_TEN,
            SIZE_FIVES, CENTS_PER_FIVE,
            SIZE_DOLLARS, CENTS_PER_DOLLAR,
            SIZE_QUARTERS, CENTS_PER_QUARTER,
            SIZE_DIMES, CENTS_PER_DIME,
            SIZE_PENNIES, CENTS_PER_PENNY
    );

    // all different bill size types
    private static final String[] sizes = {SIZE_HUNDREDS, SIZE_FIFTIES, SIZE_TWENTIES, SIZE_TENS, SIZE_FIVES, SIZE_DOLLARS, SIZE_QUARTERS, SIZE_DIMES, SIZE_PENNIES};

    public static void runChange() {
        double total = retrieveDouble("Enter amount in <dollars>.<cents> form:");
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
        for (int i = 0; i < sizes.length; i++) {
            int relation = relations.get(sizes[i]);
            int count = calculate(relation);
            if (count > 0) {
                stack.putCount(sizes[i], count);
            }
        }
    }

    // printStack uses the given stack of bill sizes and their corresponding counts to loop through them and print them
    // to the standard output.
    public static void printStack(ChangeStack stack) {
        for (int i = 0; i < sizes.length; i++) {
            String billSize = sizes[i];
            if (stack.hasCount(billSize)) {
                int count = stack.getCount(sizes[i]);
                output.printf("%d %s\n", count, billSize);
            }
        }
    }
}

class ChangeStack {
    private Map<String, Integer> counts;

    public ChangeStack() {
        counts = new HashMap<String, Integer>();
    }

    public void putCount(String billType, int count) {
        counts.put(billType, count);
    }

    public int getCount(String billType) {
        return counts.get(billType);
    }

    public boolean hasCount(String billType) {
        return counts.containsKey(billType);
    }
}