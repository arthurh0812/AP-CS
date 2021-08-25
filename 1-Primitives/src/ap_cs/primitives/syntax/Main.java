package ap_cs.primitives.syntax;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java != java");

        System.out.println("CS AP!");

        float fahrenheit = 50;
        float celsius = calcCelsius(fahrenheit);
        System.out.printf("%f Fahrenheit are the same as %f Celsius\n", fahrenheit, celsius);

        // System.out.print{"Fix me!"}:
        System.out.print("Fix me!");

        // system.out.println("CS AP!')
        System.out.println("CS AP!");


    }

    // calcCelsius calculates the degrees Celsius based on given input in degrees Fahrenheit
    public static float calcCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
