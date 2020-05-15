package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String line = scanner.nextLine();
        while (!line.equals("Reveal")) {
            String[] token = line.split(":\\|:");
            String command = token[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(token[1]);
                    String currentWord = "";
                    for (int i = 0; i < message.length(); i++) {
                        char symbol = message.charAt(i);
                        if (i == index) {
                            currentWord += " ";
                            currentWord += symbol;
                        } else {
                            currentWord += symbol;
                        }
                    }
                    System.out.println(message = currentWord);
                    break;
                case "Reverse":
                    String substring = token[1];
                    if (message.contains(substring)) {
                        int startIndex = message.indexOf(substring);
                        int endIndex = (startIndex + (substring.length() - 1));
                        StringBuilder sb = new StringBuilder(message);
                        message = sb.delete(startIndex, endIndex + 1).toString();

                        StringBuilder subs = new StringBuilder(substring);
                        substring = subs.reverse().toString();
                        System.out.println(message += substring);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    char substringChar = token[1].charAt(0);
                    char replacement = token[2].charAt(0);

                    System.out.println(message = message.replace(substringChar, replacement));

                    break;
            }
            line = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
