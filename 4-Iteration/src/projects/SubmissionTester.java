package projects;

public class SubmissionTester {
    public static void main(String[] args) {
        Submission s = new Submission();

        int count = s.countSuccessiveChars("abcXXXabc", 3);
        System.out.println(count);

        count = s.countSuccessiveChars("xxxabyyyycd", 3);
        System.out.println(count);

        String sameEnd = s.sameEnds("abXYab");
        System.out.println(sameEnd);

        sameEnd = s.sameEnds("xx");
        System.out.println(sameEnd);

        sameEnd = s.sameEnds("xxx");
        System.out.println(sameEnd);

//        s.playDiceGame();

        s.longestStreak("CFGG");
    }
}
