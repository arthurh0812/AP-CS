package projects;

public class Main {

    public static void main(String[] args) {
        int[][] nums = {{5, 6, 7}, {3, 4, 5}, {1, 2, 3}, {9, 3, 67}};

        System.out.println(getHowMany(nums, 3));

        System.out.println(getFirstNegative(nums)); // should be 0

        int[][] log = { {300, 500, 200, 450, 790, 1260}, {500, 250, 750, 200, 250, 860}, {600, 450, 160, 650, 850}};

        System.out.println(countDays(log));
        System.out.println(eatingWell(log));
    }

    public static int checkString(String[] arr) {
        int count = 0;
        return 0;
    }

    public static void q5() {
        int[] arr = {4, 3, 2, 1, 0};
        int total = 0;
        for (int k = 0; k <= total; k++)
        {
            if (arr[k] % 2 == 0)
            {
                total += arr[k];
            }
            else
            {
                total -= arr[k];
            }
        }
        System.out.print(total);
    }

    public static int getHowMany(int[][] arr, int num) {
        int count = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == num) {
                    count++;
                }
            }
        }
        return count;
    }

    // returns the value of the first found negative value of the given 2D array arr
    public static int getFirstNegative(int[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] < 0)
                    return arr[r][c];
            }
        }
        return 0;
    }

    // returns the number of days that are between 2000-2800 (incl)
    public static int countDays(int[][] log) {
        int numDays = 0;
        for (int[] day : log) {
            int totalCalories = 0;
            for (int caloriesMeal : day)
                totalCalories += caloriesMeal;
            if (2000 <= totalCalories && totalCalories <= 2800)
                numDays++;
        }
        return numDays;
    }

    public static boolean eatingWell(int[][] log) {
        int numDays = countDays(log);
        int numOtherDays = log.length - numDays;
        return numDays > numOtherDays;
    }
}
