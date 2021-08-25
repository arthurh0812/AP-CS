package ap_cs.primitives.primitive_variables;

public class Main {
    public static void main(String[] args) {

        /*s
            A Variable is a writable and readable package that holds a piece of data in computer memory (RAM).
            The value of the data is written to or read from using the pointer (memory address) of that variable.
            A convention of naming variables is camel-case, meaning "numberOfCoins" instead of "numberofcoins".
         */

        String playerName = "EIDA";
        int totalScore = 5400;
        int numCoins = 22;
        double stage = 1.1;
        double timeLeft = 367;

        timeLeft = 40;

        int numKeys; // declare the variable called numKeys
        numKeys = 2; // initialize the variable with a value of 2

        timeLeft = 120.5;
        playerName = "Parzival";
        boolean isGameOver = false;

        integers();
        doubles();
        strings();
        booleans();
    }

    public static void integers() {
        int max = Integer.MAX_VALUE; // = 2^31-1
        int min = Integer.MIN_VALUE; // = -2^31
        int defaultVal = 0;

        System.out.printf("%d, %d, %d\n", max, min, defaultVal);
    }

    public static void doubles() {
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;
        double defaultVal = 0.0;

        System.out.printf("%f, %f, %f\n", max, min, defaultVal);
    }

    public static void strings() {
        String lastName = "Halliday!";
        String firstName = "James";
        String notANumber = "2049";

        String age = "14 + 1";

        System.out.printf("last name: %s\n", lastName);
        System.out.printf("first name: %s\n", firstName);
        System.out.printf("NaN: %s\n", notANumber);
        System.out.printf("age: %s\n", age);
    }

    public static void booleans() {
        boolean isRaining = false;
        boolean isInHighSchool = true;

        if (isInHighSchool) {
            System.out.println("I am in high school.");
            if (isRaining) {
                System.out.println("Furthermore, today it is raining.");
            }
        }
    }

    final double PI = 3.1415;
    final int APScore = 3;
}
