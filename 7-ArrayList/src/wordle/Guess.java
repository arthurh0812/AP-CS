package wordle;

import java.util.ArrayList;

public class Guess {
    private final Letter[] letters;

    public Letter[] getLetters() {
        return letters;
    }

    public Guess(String solution, String guess) {
        letters = new Letter[guess.length()];
        ArrayList<Integer> matches = new ArrayList<>();
        for (int idx = 0; idx < guess.length(); idx++) {
            letters[idx] = new Letter(guess.charAt(idx), solution, idx);
            if (letters[idx].isRightSpot()) {
                matches.add(idx);
            }
        }
        for (Letter letter : letters) {
            boolean contains = false;
            for (int j = 0; j < solution.length(); j++) {
                if (!matches.contains(j) && solution.charAt(j) == letter.getLetter()) {
                    contains = true;
                    break;
                }
            }
            if (!contains)
                letter.correctContains();
        }
    }

    public boolean containsChar(char c) {
        for (Letter l : letters) {
            if (l.getLetter() == c) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Letter l : letters) {
            output.append(l.toString());
        }
        output.append("|\n");
        return output.toString();
    }
}
