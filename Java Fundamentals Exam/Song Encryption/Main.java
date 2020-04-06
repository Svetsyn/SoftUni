import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([A-Z][a-z' ]+):([A-Z\\s]+)$";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        while (!input.equals("end")) {

            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()) {
                System.out.println("Invalid input!");
            } else {
                int key = matcher.group(1).length();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == ':') {
                        sb.append("@");
                    } else if (Character.isWhitespace(input.charAt(i))) {
                        sb.append(' ');
                    } else if (input.charAt(i) == '\'') {
                        sb.append('\'');
                    } else if (Character.isLetter(input.charAt(i))) {
                        int encryptedChar = input.charAt(i) + key;
                        if (Character.isLowerCase(input.charAt(i))) {
                            int chr = encryptedChar > 'z' ? 'a' - 1 + encryptedChar % 'z' : encryptedChar;
                            sb.append((char) chr);
                        } else if (Character.isUpperCase(input.charAt(i))) {
                            int chr = encryptedChar > 'Z' ? 'A' - 1 + encryptedChar % 'Z' : encryptedChar;
                            sb.append((char) chr);
                        }
                    }
                }
                System.out.printf("Successful encryption: %s%n", sb);
            }

            input = scanner.nextLine();
        }
}
}
