import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] token = line.split("\\s+");
            String mainCommand = token[0];
            switch (mainCommand) {
                case "Translate":
                    char currentChar = token[1].charAt(0);
                    char replacementChar = token[2].charAt(0);

                    System.out.println(firstLine = firstLine.replace(currentChar, replacementChar));
                    break;

                case "Includes":
                    String stringCheck = token[1];

                    if (firstLine.contains(stringCheck)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Start":
                    String startString = token[1];
                    String[] checkString = firstLine.split(" ");
                    if (checkString[0].equals(startString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Lowercase":
                    System.out.println(firstLine = firstLine.toLowerCase());

                    break;

                case "FindIndex":
                    char charFind = token[1].charAt(0);

                    System.out.println(firstLine.lastIndexOf(charFind));
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(token[1]);
                    int count = Integer.parseInt(token[2]);
                    if ((startIndex >= 0 && startIndex < firstLine.length()) && ((startIndex + count) >= 0 && (startIndex + count) < firstLine.length())) {
                        StringBuilder sb = new StringBuilder(firstLine);
                        System.out.println(firstLine = sb.delete(startIndex, startIndex + count).toString());
                    }
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
