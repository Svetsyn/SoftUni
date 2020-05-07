import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> garages = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputInfo = scanner.nextLine().split("\\|");
            String car = inputInfo[0];
            int mileage = Integer.parseInt(inputInfo[1]);
            int fuel = Integer.parseInt(inputInfo[2]);

            garages.putIfAbsent(car, new int[2]);
            garages.get(car)[0] += mileage;
            garages.get(car)[1] += fuel;
        }

        String line = scanner.nextLine();
        while (!line.equals("Stop")) {
            String[] token = line.split(" : ");
            String command = token[0];
            String car = token[1];

            int currentCarDistance = garages.get(car)[0];
            int currentCarFuel = garages.get(car)[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(token[2]);
                    int fuel = Integer.parseInt(token[3]);
                    if (currentCarFuel > fuel) {
                        garages.get(car)[1] -= fuel;
                        garages.get(car)[0] += distance;

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    currentCarDistance = garages.get(car)[0];
                    if (currentCarDistance >= 100000) {
                        garages.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;

                case "Refuel":
                    int fuelRef = Integer.parseInt(token[2]);
                    int capacity = 75;
                    int neededLitres = 0;
                    if (currentCarFuel + fuelRef <= 75) {
                        neededLitres = fuelRef;
                        garages.get(car)[1] += neededLitres;

                    } else {
                        neededLitres = capacity - currentCarFuel;
                        garages.get(car)[1] += neededLitres;
                    }
                    System.out.printf("%s refueled with %d liters%n", car, neededLitres);
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(token[2]);
                    currentCarDistance = garages.get(car)[0] -= kilometers;
                    if (currentCarDistance >= 10000) {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    } else {
                        currentCarDistance = 10000;
                    }
                    break;

            }
            line = scanner.nextLine();
        }
        garages.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int compare = s.getValue()[0] - f.getValue()[0];

                    return compare;
                }).forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
