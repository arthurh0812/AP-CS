package projects;

public class Grades {

    int[] grades;

    public Grades(int[] newGrades) {
        grades = newGrades;
        getMode();
    }

    private int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    private double getAvg() {
        if (grades.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    private int modeValue;
    private int modeCount;

    public int getMode() {
        modeCount = 0;
        modeValue = 0;

        for (int i = 0; i < grades.length; i++) {
            int currCount = 0;
            for (int j = i; j < grades.length; j++) {
                if (grades[i] == grades[j]) {
                    currCount++;
                }
            }
            if (currCount > modeCount) {
                modeCount = currCount;
                modeValue = grades[i];
            }
        }

        return modeValue;
    }

    public int[] createGradeListWithoutMode() {
        int mode = modeValue, count = modeCount;
        int[] result = new int[grades.length-count];
        for (int i = 0, pos = 0; i < grades.length; i++) {
            if (grades[i] != mode) {
                result[pos++] = grades[i];
            }
        }
        return result;
    }

    public int getGradeRange() {
        int min = getMin(), max = getMax();
        return max - min;
    }

    public void equalizeGrades() {
        int avg = (int)getAvg();
        int diff = Math.abs(70 - avg);
        for (int i = 0; i < grades.length; i++) {
            grades[i] += diff;
        }
        getMode();
    }

    public boolean hasGradeInflation() {
        double numAs = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 90) {
                numAs++;
            }
        }
        return (numAs / grades.length) > (20.0 / 100.0);
    }

    public int numberOfGradeDrops(int n) {
        if (grades.length == 0) {
            return 0;
        }
        int count = 0;
        int successive = 0;
        int prev = grades[0];
        for (int i = 1; i < grades.length; i++) {
            int curr = grades[i];
            if (curr < prev) {
                successive++;
            } else { // reset the successive count
                successive = 0;
            }
            if (successive >= n) {
                count++;
            }
            prev = curr;
        }
        return count;
    }
}
