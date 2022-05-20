package test;

public class Main {
    // instance variables are automatically initialized
    private static String word;

    public static void main(String[] args) {
        // local variables are NOT automatically initialized
        String notInitialized;

        boolean isNull = false;

        if (word == null) {
            isNull = true;
        }

        System.out.println(isNull);
    }
}
