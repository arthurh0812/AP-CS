package projects;

import java.util.ArrayList;
import java.util.Scanner;

public class Submission {

    public int countSuccessiveChars(String word, int num) {
        int count = 0;

        // keep track of number of successive characters that are equal to one another
        int successive = 0;
        // keep track of previous character
        char previous = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr == previous) {
                successive++;
                if (successive >= num - 1)
                    count++;
            } else
                successive = 0;
            previous = curr;
        }
        return count;
    }

    public String sameEnds(String str) {
        int len = str.length();
        String sameEnd = "";

        for (int i = 0, j = len-1; i < len/2 && j >= len/2;) {
            String start = str.substring(0, i+1);
            String end = str.substring(j, len);

            if (start.equals(end) && start.length() > sameEnd.length()) {
                sameEnd = start;
            }

            i++;
            j--;
        }

        return sameEnd;
    }

    public void rollTheDice(int times, int sides) {
        // initialize the array
        int[] counter = new int[sides];

        for (int i = 1; i <= times; i++) {
            int result = (int) (Math.random() * sides) + 1;
            counter[result-1]++;
        }

        for (int i = 0; i < counter.length; i++) {
            System.out.println("A " + (i+1) + " was rolled " + counter[i] + " times.");
        }
    }

    public void playDiceGame() {
        Scanner sc = new Scanner(System.in);
        int numTimes = retrieveInt(sc, "Enter the number of times to roll the dice:", "Please enter a numeric value.");
        int numSides = retrieveInt(sc, "Enter the number of sides the dice has:", "Please enter a numeric value.");

        rollTheDice(numTimes, numSides);
    }

    public int retrieveInt(Scanner sc, String msg, String errMsg) {
        System.out.println(msg);
        while (true) {
            try {
                String line = sc.nextLine();
                return Integer.parseInt(line);
            } catch (NumberFormatException err) {
                System.out.println(errMsg);
            }
        }
    }

    public void longestStreak(String str) {
        if (str.length() == 0) {
            return;
        }
        int longest = 1;
        char longestChar = str.charAt(0);
        int consecutive = 1;
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == prev) {
                consecutive++;
                if (consecutive > longest) {
                    longest = consecutive;
                    longestChar = curr;
                }
            } else {
                consecutive = 1;
            }
            prev = curr;
        }
        System.out.println("" + longestChar + " " + longest);
    }

}
