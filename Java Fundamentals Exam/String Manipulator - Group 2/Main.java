import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern=scanner.nextLine();

        String fLine = scanner.nextLine();
        while (!fLine.equals("Done")) {
            String[] token = fLine.split("\\s+");
            String command=token[0];
            switch (command) {
                case "Change":
                    String occuranses = token[1];
                    String newChar = token[2];
                    System.out.println(pattern = pattern.replaceAll(occuranses, newChar));
                    break;
                case "Includes":
                    String current=token[1];
                    if (pattern.contains(current)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String currentEnd=token[1];
                    String[] currentMainString = pattern.split(" ");
                    for (int i = currentMainString.length-1; i >=0; i--) {
                        if (currentMainString[i].equals(currentEnd)){
                            System.out.println("True");
                            break;
                        }else {
                            System.out.println("False");
                            break;
                        }
                    }
                    break;
                case "Uppercase":
                    System.out.println(pattern = pattern.toUpperCase());
                    break;
                case "FindIndex":
                    char index = token[1].charAt(0);
                    System.out.println(pattern.indexOf(index));
                    break;
                case "Cut":
                    int startIndex=Integer.parseInt(token[1]);
                    int length =Integer.parseInt(token[2]);

                    for (int i = 0; i < pattern.length(); i++) {
                        char symbol =pattern.charAt(i);
                        if ((i>=startIndex && i<startIndex+length)){
                            System.out.print(symbol);
                        }
                    }
                    System.out.println();
                    break;
            }

            fLine = scanner.nextLine();
        }
    }
}
