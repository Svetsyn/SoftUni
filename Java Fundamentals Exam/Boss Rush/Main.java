import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String regex = "\\|(?<boss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]* [A-Za-z]*)#";
        Pattern pat =Pattern.compile(regex);

        for (int i = 0; i < num; i++) {
            String line=scanner.nextLine();
            Matcher matcher =pat.matcher(line);
            if (matcher.find()){
                String bossName = matcher.group("boss");
                String titleName = matcher.group("title");
                System.out.println(bossName+", The "+ titleName);
                System.out.print(">> Strength: ");
                System.out.println(bossName.length());
                System.out.print(">> Armour: ");
                System.out.println(titleName.length());
            }else {
                System.out.println("Access denied!");
            }
        }
    }
}
