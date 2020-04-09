package ro.pub.cs.systems.eim.Colocviu1_245.view;


public class StringUtils {
    public static final String EMPTY = "";

    public static boolean isNullOrWhiteSpace(String value) {
        if (value == null) {
            return true;
        }

        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}