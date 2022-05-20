package projects;

public class GradesTester {

    private static final int NUM_GRADES = 100;

    public static void main(String[] args) {
        int[] grades = new int[NUM_GRADES];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = (int)(Math.random() * 101);
        }

        Grades g = new Grades(grades);

        printArray(grades);
        System.out.println(g.getMode());

        System.out.println(g.getGradeRange());

        System.out.println(g.numberOfGradeDrops(2));

        System.out.println(g.hasGradeInflation());

        printArray(g.createGradeListWithoutMode());
    }

    public static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
