import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String skill = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("For Azeroth")) {
            String[] token = command.split("\\s+");
            String firstPart = token[0];
            switch (firstPart) {
                case "GladiatorStance":
                    System.out.println(skill = skill.toUpperCase());
                    break;
                case "DefensiveStance":
                    System.out.println(skill = skill.toLowerCase());
                    break;
                case "Dispel":
                    int index = Integer.parseInt(token[1]);
                    char letter = token[2].charAt(0);
                    if (index >= 0 && index < skill.length()) {
                        String skillNew = "";
                        for (int i = 0; i < skill.length(); i++) {
                            char currentSymbol = skill.charAt(i);
                            if (i == index) {
                                skillNew += letter;
                            } else {
                                skillNew += currentSymbol;
                            }
                        }
                        skill = skillNew;
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    String additionalCommand = token[1];
                    if (additionalCommand.equals("Change")) {
                        String substring = token[2];
                        String secondSubstring = token[3];

                        System.out.println(skill = skill.replace(substring, secondSubstring));
                    } else if (additionalCommand.equals("Remove")) {
                        String substring =token[2];
                        String newSubstring="";
                        System.out.println(skill = skill.replace(substring, newSubstring));
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }

            command = scanner.nextLine();
        }
    }
}



