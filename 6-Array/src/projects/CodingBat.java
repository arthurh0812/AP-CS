package projects;

public class CodingBat {

    public static void main(String[] args) {
        System.out.println(centeredAverage(new int[]{7, 7, 7}));
    }

    public static int centeredAverage(int[] nums) {
        int maxIdx = 2, maxVal = Integer.MIN_VALUE;
        int minIdx = 0, minVal = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < minVal) {
                minVal = curr;
                minIdx = i;
            }
            if (curr >= maxVal) {
                maxVal = curr;
                maxIdx = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != minIdx && i != maxIdx) {
                sum += nums[i];
            }
        }
        return sum/(nums.length-2);
    }

}
