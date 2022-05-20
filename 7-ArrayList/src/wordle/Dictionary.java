package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Dictionary {
    private final ArrayList<String> words;

    private final int wordLength;
    private final boolean easy;

    public Dictionary(String filename, int wordLength, boolean easy) throws FileNotFoundException {
        this.words = new ArrayList<>();
        this.wordLength = wordLength;
        this.easy = easy;
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String word = sc.nextLine();
            word = word.toUpperCase(Locale.ROOT);
            if (easy && word.length() == wordLength && areLettersUnique(word)) {
                words.add(word);
            }
            if (!easy && word.length() == wordLength) {
                words.add(word);
            }

        }
        sortWords();
        sc.close();
    }

    // selection sorting algorithm
    public void sortWords() {
        for (int i = 0; i < words.size(); i++) {
            int minIdx = i;
            String minValue = words.get(i);
            for (int j = i; j < words.size(); j++) {
                // compare selection against min value and swap if there is a new min value
                if (words.get(j).compareTo(minValue) < 0) {
                    minIdx = j;
                    minValue = words.get(j);
                }
            }
            if (i != minIdx) {
                // swap min element with current element
                String temp = words.get(i);
                words.set(i, minValue);
                words.set(minIdx, temp);
            }
        }
    }

    public static boolean areLettersUnique(String word) {
        String already = "";
        for (int i = 0; i < word.length(); i++) {
            if (!already.contains(word.substring(i, i+1))) {
                already = already + word.charAt(i);
            } else {
                return false;
            }
        }
        return true;
    }

    public String getRandom() {
        int randomIdx = (int) (Math.random() * words.size());
        return words.get(randomIdx);
    }

    public boolean isValid(String word) {
        if (word.length() != wordLength) {
            return false;
        }
        if (easy && !areLettersUnique(word)) {
            return false;
        }
        return contains(word);
    }

    // binary search algorithm
    public boolean contains(String word) {
        int left = 0, right = words.size()-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            String pivot = words.get(mid);
            if (pivot.compareTo(word) == 0) {
                return true;
            } else if (pivot.compareTo(word) > 0) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}
