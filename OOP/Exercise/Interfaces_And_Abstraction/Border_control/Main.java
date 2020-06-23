package border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> collection = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] input = line.split(" ");
            if (input.length == 2) {
                collection.add(input[1]);
            } else {
                collection.add(input[2]);
            }

            line = scanner.nextLine();
        }
        String verify = scanner.nextLine();
        collection.stream().filter(s -> s.endsWith(verify)).forEach(System.out::println);
    }

}
