public class Test {

    public static int divBySum(int[] arr, int num) {
        int sum = 0;
        for (int val : arr) {if (val % num == 0) {sum++;}}return sum;
    }
}
