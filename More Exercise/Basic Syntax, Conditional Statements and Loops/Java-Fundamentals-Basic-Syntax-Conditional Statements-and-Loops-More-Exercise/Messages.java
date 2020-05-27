import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfPush = Integer.parseInt(scanner.nextLine());

        String message = "";
        int offset = 0;
        for (int i = 0; i < numbersOfPush; i++) {
            String digits = scanner.nextLine();

            int digitLength = digits.length();
            char oneDigit = digits.charAt(0);
            int mainDigit = Character.getNumericValue(oneDigit);

            if (mainDigit == 8 || mainDigit == 9) {
                offset = (mainDigit - 2) * 3 + 1;
            } else {
                offset = (mainDigit - 2) * 3;
            }

            int letterIndex = offset + digitLength - 1;
            int letterCode = letterIndex + 97;

            char letter = (char) letterCode;
            if (mainDigit == 0) {
                letter = (char) (mainDigit + 32);
            }
            message += letter;
        }
        System.out.println(message);
    }
}