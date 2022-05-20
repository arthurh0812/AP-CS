package wordle;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("----WORDLE----");
        int wordLength = retrieveInt("Word Length: ", true);
        boolean easy = retrieveBool("Easy Mode: (y/n)");

        Wordle w = new Wordle(wordLength, easy);

        boolean guessed = false;

        for (int i = 0; i < 6; i++) {
            System.out.println("Take a word guess:");
            String line = sc.nextLine();
            while (!w.takeGuess(line)) {
                System.out.println("Enter a valid word:");
                line = sc.nextLine();
            }
            System.out.println(w.displayGuesses());
            if (w.isGameOver()) {
                displayWin(w);
                guessed = true;
                break;
            }
            System.out.println(w.displayAlphabet());
        }

        if (!guessed) {
            System.out.println("The correct word would have been: " + w.getSolution());
        }
    }

    public static void displayWin(Wordle w) {
        System.out.println("Congrats! You guessed the correct word at row " + w.getWinRow() + "!");
    }

    public static int retrieveInt(String msg, boolean positive) {
        System.out.println(msg);
        String line = sc.nextLine();
        while (true) {
            try {
                int i = Integer.parseInt(line);
                if (positive && i > 0) {
                    return i;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException err) {
                System.out.println("Please enter a valid integer");
                line = sc.nextLine();
            }
        }
    }

    public static boolean retrieveBool(String msg) {
        System.out.println(msg);
        return sc.nextLine().equalsIgnoreCase("y");
    }
}
