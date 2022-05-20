package wordle;

import java.io.FileNotFoundException;
import java.util.Locale;

public class Wordle {
    private Dictionary dictionary;

    private final Guess[] guesses;
    private int currentGuess = 0;
    private int winRow = -1;

    private final String solution;
    public String getSolution() {
        return solution;
    }

    private int wordLength;
    
    public Wordle(int wordLength, boolean easy) throws FileNotFoundException {
        this.wordLength = wordLength;
        try {
            dictionary = new Dictionary("./src/wordle/words.txt", wordLength, easy);
        } catch (FileNotFoundException err) {
            System.out.println("something went wrong...");
        }
        guesses = new Guess[6];
        solution = dictionary.getRandom().toUpperCase(Locale.ROOT);
    }

    public boolean takeGuess(String word) {
        word = word.toUpperCase(Locale.ROOT);
        if (!dictionary.isValid(word)) {
            return false;
        }
        addGuess(word);
        if (solution.equals(word)) {
            winRow = currentGuess;
        }
        currentGuess++;
        return true;
    }

    private void addGuess(String word) {
        guesses[currentGuess] = new Guess(solution, word);
    }

    public String displayGuesses() {
        StringBuilder output = new StringBuilder();
        for (Guess guess : guesses) {
            if (guess != null)
                output.append(guess);
            else
                output.append(displayEmpty());
        }
        return output.toString();
    }

    public String displayEmpty() {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < wordLength; i++) {
            output.append("| ");
        }
        output.append("|\n");
        return output.toString();
    }

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String displayAlphabet() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < ALPHABET.length(); i++) {
            displayLetter(ALPHABET.charAt(i), output);
        }
        output.append("\n");
        return output.toString();
    }

    public void displayLetter(char alphabetical, StringBuilder output) {
        boolean isRightSpot = false;
        boolean isIncluded = false;
        boolean isWrong = false;
        for (int i = 0; i < guesses.length && guesses[i] != null; i++) {
            for (Letter l : guesses[i].getLetters()) {
                if (l.getLetter() != alphabetical) {
                    continue;
                }
                if (l.isRightSpot()) {
                    isRightSpot = true;
                } else if (l.isIncluded()) {
                    isIncluded = true;
                } else {
                    isWrong = true;
                }
            }
        }
        if (isRightSpot)
            output.append(Letter.GREEN).append(alphabetical).append(Letter.RESET).append(" ");
        else if (isIncluded)
            output.append(Letter.YELLOW).append(alphabetical).append(Letter.RESET).append(" ");
        else if (isWrong)
            output.append(Letter.RED).append(alphabetical).append(Letter.RESET).append(" ");
        else
            output.append(alphabetical).append(" ");
    }

    public boolean isGameOver() {
        return winRow >= 0;
    }

    public int getWinRow() {
        return winRow+1;
    }
}
