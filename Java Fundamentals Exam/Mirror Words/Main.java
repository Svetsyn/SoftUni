import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String regex = "([@#])[a-zA-Z]{3,}(\\1)(\\1)[a-zA-Z]{3,}(\\1)";
        List<String> collection = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String matcherFromList = matcher.group();
            collection.add(matcherFromList);
        }

        List<String> mirror = new ArrayList<>();
        if (!collection.isEmpty()) {
            System.out.println(collection.size() + " word pairs found!");

            String regexTwo = "(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
            Pattern pattern2 = Pattern.compile(regexTwo);

            for (String col : collection) {
                Matcher matcher1 = pattern2.matcher(col);
                if (matcher1.find()) {
                    String first = matcher1.group("first");//oop
                    String second = matcher1.group("second");//poo

                    String control = "";
                    for (int i = second.length() - 1; i >= 0; i--) {
                        char symbol = second.charAt(i);
                        control += symbol;
                    }
                    if (control.equals(first)) {
                        String forAdded=first+" <=> "+second;
                        mirror.add(forAdded);
                    }
                }
            }
        } else {
            System.out.println("No word pairs found!");
        }

        if (mirror.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are: ");
            System.out.println(String.join(", ",mirror));
        }
    }
}
