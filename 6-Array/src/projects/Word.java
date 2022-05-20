package projects;

public class Word {
    private String word;

    public Word(String w) {
        this.word = w;
    }

    public int length() {
        return word.length();
    }

    public void addChar(char c) {
        word = word + c;
    }

    public static int getAlphabetIndex(char c) {
        return c - 'a';
    }

    // from 'a' to 'z'                            a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q   r  s  t  u  v  w  x  y  z
    private static final int[] SCRABBLE_POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    public static int getLetterValue(char letter) {
        int charValue = getAlphabetIndex(letter);
        return SCRABBLE_POINTS[charValue];
    }

    public int getValue() {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.toLowerCase().charAt(i);
            sum += getLetterValue(letter);
        }
        return sum;
    }

    public String toString() {
        return word;
    }
}
