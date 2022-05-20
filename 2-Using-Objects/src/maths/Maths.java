package maths;

public class Maths {
    public static void printSquare(double x) {
        double y = Math.sqrt(x);
        System.out.println("The square root of " + x + " is " + y);
    }

    public static void multiply(int j, int m) {
        int k = j * Math.abs(m);
    }

    public static void storeInt() {
        int res = (int) Math.abs(-127.5);
    }

    public static int max(int x, int k, int j) {
        return Math.max(x, Math.max(k, j));
    }

    public static double task5(int x, int k, int j) {
        return Math.pow(x, Math.abs(k-j));
    }

    public static void task6() {
        System.out.println( Math.ceil(-157.2) );

        System.out.println( Math.floor(-157.2) );

        System.out.println( Math.ceil(157.2) );

        System.out.println( Math.floor(157.2) );

        System.out.println( Math.round(-157.2) );

        System.out.println( Math.ceil(-157.7) );

        System.out.println( Math.ceil(157) );
    }

    public static double floor(double x) {
        return (int) x - (x % 1 < 0 ? 1 : 0);
    }

    public static double ceil(double x) {
        return (int) x + (x % 1 < 0 ? 1 : 0);
    }

    public static double round(double x) {
        return (int) x + (x > 0 ? 0.5 : -0.5);
    }

    public static void printRandom(int x) {
        int r = (int) (Math.random() * x) + 1;
        System.out.println("A random number between 1 and " + x + " is " + r);
    }

    public static int rollDice() {
        int r = (int) (Math.random() * 12) + 2;
        return r;
    }

    public static void convertToDoubleWrapper() {
        double num = 4.5;
        Double numWrapper = new Double(num);
    }

    public static void convertToIntWrapper() {
        int ip = 45624;
        Integer intWrapper = new Integer(ip);
    }

    public static void task12() {
        Double d1 = new Double(4.7);
        Double d2 = new Double(34.94);
        double result = d1.intValue() * d2.intValue();
    }

    public static void task13() {
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(35);
        Integer i3 = i1.intValue() + i2.intValue();
    }

    public static void main(String[] args) {
        task6();

    }
}
