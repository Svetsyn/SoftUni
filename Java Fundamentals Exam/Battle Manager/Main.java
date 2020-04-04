import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> collection = new TreeMap<>();
        String line = scanner.nextLine();
        while (!line.equals("Results")) {
            String[] token = line.split(":");
            String command = token[0];

            switch (command) {
                case "Add":
                    String name = token[1];
                    int health = Integer.parseInt(token[2]);
                    int energy = Integer.parseInt(token[3]);

                    if (!collection.containsKey(name)) {
                        collection.put(name, new int[2]);
                        collection.get(name)[0] = health;
                        collection.get(name)[1] = energy;
                    } else {
                        int currentHealt = collection.get(name)[0];
                        collection.get(name)[0] = currentHealt + health;
                    }
                    break;
                case "Attack":
                    String attackName = token[1];
                    String defenderName = token[2];
                    int damage = Integer.parseInt(token[3]);

                    if (collection.containsKey(attackName) && collection.containsKey(defenderName)) {
                        int currentAttackEnergy = collection.get(attackName)[1];
                        int currentHealtDefenderName = collection.get(defenderName)[0];
                        collection.get(defenderName)[0] = currentHealtDefenderName - damage;
                        collection.get(attackName)[1] = currentAttackEnergy - 1;

                        if ((collection.get(defenderName)[0]) <= 0) {
                            collection.remove(defenderName);
                            System.out.println(defenderName + " was disqualified!");
                        }

                        if ((collection.get(attackName)[1]) <= 0) {
                            collection.remove(attackName);
                            System.out.println(attackName + " was disqualified!");
                        }
                    }

                    break;
                case "Delete":
                    String username = token[1];
                    if (username.equals("All")) {
                        collection.clear();
                    } else {
                        collection.remove(username);
                    }
                    break;

            }
            line = scanner.nextLine();
        }
        System.out.println("People count: " + collection.size());
        collection.entrySet()
                .stream()
                .sorted((f, s) -> s.getValue()[0] - f.getValue()[0])
                .forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()[0] + " - " + entry.getValue()[1]));

    }
}
