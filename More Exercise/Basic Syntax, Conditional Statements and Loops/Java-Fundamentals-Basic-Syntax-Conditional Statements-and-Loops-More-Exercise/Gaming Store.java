import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scanner.nextLine());
        List<String> collection = new ArrayList<>();
        String line = scanner.nextLine();

        double price = 0;
        double totalSpent = 0.0;
        while (!line.equals("Game Time")) {
            switch (line) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    line = scanner.nextLine();
                    continue;
            }
            if (price > currentBalance) {
                System.out.println("Too Expensive");
            } else {
                if (currentBalance == 0) {
                    System.out.println("Out of money!");
                    break;
                } else {
                    currentBalance -= price;
                    totalSpent += price;
                    System.out.println("Bought "+line);
                    if (currentBalance==0){
                        System.out.println("Out of money!");
                    }
                }
            }
            line = scanner.nextLine();
        }

        if (currentBalance>0){

            System.out.printf("Total spent: $%.2f. Remaining: $%.2f",totalSpent,currentBalance);
        }
    }
}