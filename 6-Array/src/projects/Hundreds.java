package projects;

public class Hundreds {

    public static void main(String[] args) {

        int[] hundreds = new int[1000];

        int sum = 0;

        for (int i = 0; i < hundreds.length; i++) {
            int randomValue = (int) (Math.random() * hundreds.length) + 1;
            hundreds[i] = randomValue;
            sum += randomValue;
        }

        System.out.println((double)sum / hundreds.length);

        int count = 0;

        for (int i = 0; i < hundreds.length; i++) {
            if (hundreds[i] == 20) {
                count++;
            }
        }

        System.out.println("count of 20s: " + count);
    }
}

