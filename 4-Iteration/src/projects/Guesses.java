package projects;

import java.util.Scanner;
import java.io.PrintStream;

public class Guesses {

    private static Scanner input;
    private static PrintStream output;

    private static int range;

    public static void main(String[] args) {
        IO();

        while (true) {
            setRange();
            int target = generateTarget();
            int guess = retrieveInt("Take a guess between 1 and " + range);
            int numGuesses = 1;

            boolean outOfGuesses = false;

            while (guess != target) {
                numGuesses++;
                if (numGuesses > 10) {
                    outOfGuesses = true;
                    break;
                }
                giveHint(guess, target);

                guess = retrieveInt(null);
            }
            if (!outOfGuesses) {
                output.println("Congratulations! You took " + numGuesses + " to guess the target of " + target);
            } else {
                output.println("You already took 10 guesses...");
            }
            output.println("Play again? (y/n)");
            String res = input.nextLine();
            if (res.equalsIgnoreCase("n")) {
                break;
            }
        }

        closeIO();
    }

    private static void IO() {
        input = new Scanner(System.in);
        output = new PrintStream(System.out);
    }

    private static void closeIO() {
        input.close();
        output.close();
    }

    private static void setRange() {
        output.println("Please enter the difficulty: ");
        while (true) {
            String difficulty = input.nextLine();
            if (difficulty.equalsIgnoreCase("easy")) {
                range = 100;
                break;
            } else if (difficulty.equalsIgnoreCase("medium")) {
                range = 1000;
                break;
            } else if (difficulty.equalsIgnoreCase("hard")) {
                range = 10000;
                break;
            } else if (difficulty.equalsIgnoreCase("impossible")) {
                range = 1000000;
                break;
            } else {
                System.out.println("Please enter a valid difficulty: (EASY, MEDIUM, HARD or IMPOSSIBLE");
            }
        }
    }

    private static int retrieveInt(String msg) {
        while (true) {
            if (msg != null) {
                output.println(msg);
            }
            try {
                String line = input.nextLine();
                return Integer.parseInt(line);
            } catch (NumberFormatException err) {
                output.println("Please enter a valid integer");
            }
        }
    }

    private static int generateTarget() {
        return (int) (Math.random()* range) + 1;
    }

    // precondition: guess != target
    private static void giveHint(int guess, int target) {
        if (guess < target) {
            output.println("Higher!");
        } else if (target < guess){
            output.println("Lower!");
        }
    }
}
