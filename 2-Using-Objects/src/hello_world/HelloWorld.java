package hello_world;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(floor(5.3));
        System.out.println(floor(-5.3));
        System.out.println(floor(0));
    }

//    public static int floor(double n) {
//        if (n <= 0 && n % 1 < 0) {
//            return (int) n - 1;
//        }
//        return (int) n;
//    }

    public static int floor(double n) {
        return (int) n - (n % 1 < 0 ? 1 : 0);
    }
}
