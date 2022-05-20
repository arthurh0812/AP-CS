package projects;

import java.util.ArrayList;

public class Scrabble {
    private final char[][] board;

    public Scrabble(char[][] board) {
        this.board = board;
    }

    private void searchHorizontal(ArrayList<Word> toAdd) {
        for (char[] chars : board) {
            Word temp = null;
            boolean isWord = false;
            for (int c = 0; c < board[0].length; c++) {
                char curr = chars[c];
                if (curr == ' ' || c == board[0].length-1) {
                    isWord = false;
                    if (temp != null && temp.length() > 1)
                        toAdd.add(temp);
                    temp = null;
                } else if (!isWord) {
                    isWord = true;
                    String w = String.valueOf(curr);
                    temp = new Word(w);
                } else {
                    temp.addChar(curr);
                }
            }
        }
    }

    private void searchVertical(ArrayList<Word> toAdd) {
        for (int c = 0; c < board[0].length; c++) {
            Word temp = null;
            boolean isWord = false;
            for (int r = 0; r < board.length; r++) {
                char curr = board[r][c];
                if (curr == ' ' || r == board.length-1) {
                    isWord = false;
                    if (temp != null && temp.length() > 1)
                        toAdd.add(temp);
                    temp = null;
                } else if (!isWord){
                    isWord = true;
                    String w = "" + curr;
                    temp = new Word(w);
                } else {
                    temp.addChar(curr);
                }
            }
        }
    }

    public Word[] getWordListFromBoard() {
        ArrayList<Word> words = new ArrayList<>();
        searchHorizontal(words);
        searchVertical(words);
        Word[] arr  = new Word[words.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = words.get(i);
        }
        return arr;
    }

    public Word getMostValuableWordFromBoard() {
        Word[] words = getWordListFromBoard();
        return getMostValuableWord(words);
    }

    public double getAverageWordValueFromBoard() {
        Word[] words = getWordListFromBoard();
        return getAvgValue(words);
    }

    public static Word getMostValuableWord(Word[] list) {
        Word maxWord = null;
        int maxWordValue = 0;
        for (Word currWord : list) {
            int wordValue = currWord.getValue();
            if (wordValue > maxWordValue) {
                maxWordValue = wordValue;
                maxWord = currWord;
            }
        }
        return maxWord;
    }

    public static double getAvgValue(Word[] list) {
        int sum = 0;
        for (Word currWord : list) {
            sum += currWord.getValue();
        }
        return (double)sum/list.length;
    }
}
