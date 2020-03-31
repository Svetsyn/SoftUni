import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String regex = "([*|@])(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<first>[A-Za-z])\\]\\|\\[(?<second>[A-Za-z])\\]\\|\\[(?<third>[A-Za-z])\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                int first = (int)matcher.group("first").charAt(0);
                int second = (int)matcher.group("second").charAt(0);
                int third = (int)matcher.group("third").charAt(0);
                System.out.println(tag + ": " + first + " " + second + " " + third);
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
