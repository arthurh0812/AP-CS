package constuctor;

public class PhoneRunner {
    public static void main(String[] args) {

        //Test-1
        Phone a = new Phone ( "iPhone 500", 6.1 );
        System.out.println(a.getVars());

        //Test-2
        Phone b = new Phone ("Galaxy 3000",  6.9 );
        System.out.println(b.getVars());

        //Test-3
        Phone c = new Phone ("Nokia 777",  5.8 );
        System.out.println(c.getVars());
    }
}
