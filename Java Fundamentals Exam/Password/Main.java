import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String regex = "([\\w]+|[\\W]+)>(?<first>[0-9]{3})\\|(?<second>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[\\W\\w]{3})<(\\1)";
        Pattern pat = Pattern.compile(regex);

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pat.matcher(line);
            if (matcher.find()) {
                String first = matcher.group("first");
                String second = matcher.group("second");
                String third = matcher.group("third");
                String fourth = matcher.group("fourth");

                System.out.println("Password: " + first + second + third + fourth);

            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
