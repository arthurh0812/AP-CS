package projects.strings;

public class Strings {
    public static String last4(String ccNumber) {
        String withoutSpaces = ccNumber.replace(" ", "");
        return withoutSpaces.substring(ccNumber.length()-4);
    }

    public static String first5(String ccNumber) {
        String withoutSpaces = ccNumber.replace(" ", "");
        return withoutSpaces.substring(0, 5);
    }

    public static String scroll(String s) {
        if (s.length() <= 0) {
            return "";
        }
        char first = s.charAt(0);
        return s.substring(1) + first;
    }

    public static String convertName(String name) {
        String[] names = name.split(", ");
        if (names.length < 2) {
            return "";
        }
        return names[1] + " " + names[0];
    }

    public static String cutOut(String str, String cut) {
        int idx = str.indexOf(cut);
        if (idx == -1) {
            return str;
        }
        return str.substring(0, idx) + str.substring(idx+cut.length());
    }

    public static String rename(String name) {
        int idx = (int) (Math.random() * name.length());
        char c = name.charAt(idx);
        return Character.toUpperCase(c) + name.substring(0, idx).toLowerCase() + name.substring(idx+1).toLowerCase();
    }

    private static final String DOT = ".";

    public static String fixFileName(String filename) {
        String[] data = filename.toUpperCase().split("\\.");
        String name = data[0], ext = data[1];
        if (name.length() > 8) {
            name = name.substring(0, 8);
        }
        if (ext.length() > 3) {
            ext = ext.substring(0, 3);
        }
        return name + DOT + ext;
    }
}
