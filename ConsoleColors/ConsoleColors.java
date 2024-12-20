package ConsoleColors;

// from https://stackoverflow.com/a/45444716

public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m"; // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m"; // BLACK
    public static final String RED = "\033[0;31m"; // RED
    public static final String GREEN = "\033[0;32m"; // GREEN
    public static final String YELLOW = "\033[0;33m"; // YELLOW
    public static final String BLUE = "\033[0;34m"; // BLUE
    public static final String PURPLE = "\033[0;35m"; // PURPLE
    public static final String CYAN = "\033[0;36m"; // CYAN
    public static final String WHITE = "\033[0;37m"; // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
    public static final String WHITE_BOLD = "\033[1;37m"; // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m"; // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m"; // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m"; // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m"; // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m"; // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m"; // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
    public static final String RED_BACKGROUND = "\033[41m"; // RED
    public static final String GREEN_BACKGROUND = "\033[42m"; // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m"; // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m"; // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m"; // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m"; // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m"; // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m"; // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m"; // WHITE

    public static String RGB_BRIGHT(int red, int green, int blue) {
        return "\033[48;2;" + red + ";" + green + ";" + blue + "m";
    }

    public static String HEX_BRIGHT_ZS_6(String keyCharacterBytes, String text) {
        // System.out.println(keyCharacterBytes);
        switch (keyCharacterBytes) {
            case "CONTIN":
                return text;
            case "RETURN":
                return RESET + "\n";
            case "RESETT":
                return RESET + text;
            default:
                final String rgbR = keyCharacterBytes.substring(0, 2);
                final String rgbG = keyCharacterBytes.substring(2, 4);
                final String rgbB = keyCharacterBytes.substring(4, 6);

                final int hexR = Integer.parseInt(rgbR, 16);
                final int hexG = Integer.parseInt(rgbG, 16);
                final int hexB = Integer.parseInt(rgbB, 16);
                return "\033[48;2;" + hexR + ";" + hexG + ";" + hexB + "m" + text;
        }
        // return "\033[48;2;#" + keyCharacterBytes + "m";
    }

    public static String HEX_BRIGHT_ZS_3(String keyCharacterBytes, String text) {
        // System.out.println(keyCharacterBytes);
        switch (keyCharacterBytes) {
            case "CON":
                return text;
            case "RET":
                return RESET + "\n";
            case "RES":
                return RESET + text;
            default:
                final String rgbR = keyCharacterBytes.substring(0, 1);
                final String rgbG = keyCharacterBytes.substring(1, 2);
                final String rgbB = keyCharacterBytes.substring(2, 3);

                final int hexR = Integer.parseInt(rgbR + rgbR, 16);
                final int hexG = Integer.parseInt(rgbG + rgbG, 16);
                final int hexB = Integer.parseInt(rgbB + rgbB, 16);
                return "\033[48;2;" + hexR + ";" + hexG + ";" + hexB + "m" + text;
        }
    }

    public static String HEX_BRIGHT_ZS_C(String keyCharacterBytes, String text) {
        // System.out.println(keyCharacterBytes);
        switch (keyCharacterBytes) {
            case "CO":
                return text;
            case "RE":
                return RESET + "\n";
            case "RS":
                return RESET + text;
            default:
                return "\033[48;5;" + Integer.parseInt(keyCharacterBytes, 16) + "m" + text;
        }
    }

    public static String HEX_BRIGHT(String keyCharacterBytes, String text) {
        // System.out.println(keyCharacterBytes);
        final String rgbR = keyCharacterBytes.substring(0, 2);
        final String rgbG = keyCharacterBytes.substring(2, 4);
        final String rgbB = keyCharacterBytes.substring(4, 6);

        final int hexR = Integer.parseInt(rgbR, 16);
        final int hexG = Integer.parseInt(rgbG, 16);
        final int hexB = Integer.parseInt(rgbB, 16);
        return "\033[48;2;" + hexR + ";" + hexG + ";" + hexB + "m";

        // return "\033[48;2;#" + keyCharacterBytes + "m";
    }
}