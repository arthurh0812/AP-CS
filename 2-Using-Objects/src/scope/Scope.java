package scope;

public class Scope {
    public static void main(String args[])
    {
        int a = 3;

        for(int i = 0; i < 3; i++)
        {
            int c = 0;
            c = c + 2;
            a = a + 1;
            System.out.print( c );
            System.out.println( i );
        }
        System.out.println( a );
    }

    // Output:
    // 20
    // 21
    // 22
    // 6
}