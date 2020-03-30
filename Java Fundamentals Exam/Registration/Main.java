import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String regex = "\\b([U]\\$)(?<username>[A-Z][a-z]{2,})\\1([P]@\\$)(?<password>[A-Za-z]{5,}[0-9]+)\\3";
        Pattern pat = Pattern.compile(regex);
        int succ = 0;
        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pat.matcher(line);
            if (matcher.find()) {
                String user = matcher.group("username");
                String pas = matcher.group("password");
                succ++;
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", user, pas);
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.print("Successful registrations: " + succ);
    }
}
