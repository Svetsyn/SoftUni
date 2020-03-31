import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String regex = "^([$|%])(?<tag>[A-Z][a-z]{3,})(\\1): \\[(?<first>[0-9]+)\\]\\|\\[(?<second>[0-9]+)\\]\\|\\[(?<third>[0-9]+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                int first = Integer.parseInt(matcher.group("first"));
                char firsCast = (char) first;
                int second = Integer.parseInt(matcher.group("second"));
                char secondCast = (char) second;
                int third = Integer.parseInt(matcher.group("third"));
                char thirdCast = (char) third;

                System.out.println(tag + ": " + firsCast + secondCast + thirdCast);
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
