package ap_cs.primitives.mathematical_operators;

public class Main {
    public static void main(String[] args) {
        int num = 2 + (5 - 2) * 2 - 1;
        System.out.println(num); // 7

        modulo();
        num = 45;
        int last2Digits = getLastNDigits(num, 10, 2);
        System.out.printf("last 2 digits: %d\n", last2Digits); // 45
        int last3Digits = getLastNDigits(36792, 10, 3);
        System.out.printf("last 3 digits: %d\n", last3Digits); // 792

        shorthandOperators();

        int bitcoins = 5;
        System.out.printf("%d bitcoins are worth %d$\n", bitcoins, convertBitcoinToDollar(bitcoins));
    }

    public static void modulo() {
        /* even or odd */
        for (int i = 0; i < 10; i++) {
            if (i%2 == 0) {
                System.out.printf("even number: %d\n", i);
            } else {
                System.out.printf("odd number: %d\n", i);
            }
        }
    }

    public static int getLastNDigits(int num, int base, int n) {
        double baseDouble = base, nDouble = n;
        int modulo = (int)Math.pow(baseDouble, nDouble);
        return num%modulo;
    }

    public static void shorthandOperators() {
        int n = 3;
        n++;    // n = n + 1
        n += 1; // n = n + 1

        System.out.println(n); // 5

        n *= 5;

        System.out.println(n); // 25

        n--;
        n /= 4;

        System.out.println(n); // 6

        int a = 9;
        System.out.println(a / 3.0);
    }

    final static int BITCOIN_DOLLAR_FACTOR = 55000;

    public static int convertBitcoinToDollar(int bitcoin) {
        return bitcoin * BITCOIN_DOLLAR_FACTOR;
    }
}
