package wordle;

public class Letter {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";

    private final boolean isRightSpot;
    private boolean isIncluded;

    public void correctContains() {
        isIncluded = false;
    }
    private final char letter;

    public char getLetter() {
        return letter;
    }

    public Letter(char letter, String solution, int idx) {
        this.letter = letter;
        this.isIncluded = true;
        this.isRightSpot = solution.charAt(idx) == letter;
    }

    public boolean isRightSpot() {
        return isRightSpot;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public String toString() {
        if (isRightSpot) { // green
            return "|" + GREEN + letter + RESET;
        } else if (isIncluded) { // yellow
            return "|" + YELLOW + letter + RESET;
        } else { // regular
            return "|" + RED + letter + RESET;
        }
    }
}
