import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("Sign up")) {
            String[] command = line.split("\\s+");
            String firstCommand = command[0];

            switch (firstCommand) {

                case "Case":
                    String secondCommand = command[1];
                    if (secondCommand.equals("lower")) {
                        System.out.println(username = username.toLowerCase());
                    } else if (secondCommand.equals("upper")) {
                        System.out.println(username = username.toUpperCase());
                    }
                    break;

                case "Reverse":
                    int start = Integer.parseInt(command[1]);
                    int fin = Integer.parseInt(command[2]);

                    if ( (start >= 0 && start < username.length()) && fin>=0 &&fin<username.length()){
                        String reverse=username.substring(start,fin+1);

                        for (int i = reverse.length()-1; i >=0 ; i--) {
                            char symbol=reverse.charAt(i);
                            System.out.print(symbol);
                        }
                        System.out.println();
                    }

                    break;
                case "Cut":
                    String substring=command[1];
                    String newString="";
                    if (username.contains(substring)){
                        System.out.println(username = username.replace(substring, newString));
                    }else {
                        System.out.printf("The word %s doesn't contain %s.%n",username,substring);
                    }
                    break;
                case "Replace":
                    char chare=command[1].charAt(0);
                    System.out.println(username = username.replace(chare, '*'));
                    break;
                case "Check":
                    String charela=command[1];
                    if (username.contains(charela)){
                        System.out.println("Valid");
                    }else {
                        System.out.println("Your username must contain "+charela+".");
                    }
                    break;
            }

            line = scanner.nextLine();
        }

    }
}
