import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String regex = "(\\!)(?<command>[A-Z][a-z]{2,})(\\1):\\[(?<letter>[A-Za-z]{8,})\\]";
        Pattern pat = Pattern.compile(regex);

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pat.matcher(line);
            if (matcher.find()) {
                String command = matcher.group("command");
                String message = matcher.group("letter");
                System.out.print(command + ": ");
                for (int k = 0; k < message.length(); k++) {
                    char symbol = message.charAt(k);
                    System.out.print((int) symbol + " ");
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
