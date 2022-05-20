package projects.strings;

public class StringsRunner {
    public static void main(String[] args) {
        String ccNumber = "4111 1111 1111 1111";
        System.out.println(Strings.last4(ccNumber));
        System.out.println(Strings.first5(ccNumber));

        System.out.println(Strings.scroll("scroll"));

        System.out.println(Strings.convertName("Peng, Michael"));

        System.out.println(Strings.cutOut("something", "thing"));

        System.out.println(Strings.cutOut("randomtextidontknow", "tex"));

        System.out.println(Strings.rename("Oscar"));

        System.out.println(Strings.fixFileName("SOMETHING.PPTX")); // "SOMETHIN.PPT"
    }
}
