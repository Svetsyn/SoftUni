import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> collection = new TreeMap<>();
        int capacity = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        while (!line.equals("Statistics")) {
            String[] token = line.split("=");
            String command = token[0];

            switch (command) {
                case "Add":
                    String username = token[1];
                    int sent = Integer.parseInt(token[2]);
                    int received = Integer.parseInt(token[3]);
                    if (!collection.containsKey(username)) {
                        collection.put(username, new int[2]);
                        collection.get(username)[0] = sent;
                        collection.get(username)[1] = received;
                    }
                    break;

                case "Message":
                    String sender = token[1];
                    String receiver = token[2];
                    if (collection.containsKey(sender) && collection.containsKey(receiver)) {
                        collection.get(sender)[0] += 1;
                        collection.get(receiver)[1] += 1;
//                        int currentSender = collection.get(sender)[0];
//                        int currentReceiver = collection.get(receiver)[1];
                        if ((collection.get(sender)[0] + collection.get(sender)[1]) >= capacity) {
                            System.out.printf("%s reached the capacity!%n", sender);
                            collection.remove(sender);
                        }
                        if ((collection.get(receiver)[0] + collection.get(receiver)[1]) >= capacity) {
                            System.out.printf("%s reached the capacity!%n", receiver);
                            collection.remove(receiver);
                        }
                    }
                    break;

                case "Empty":
                    String usernameEmpty = token[1];

                    String replaced = "";
                    if (usernameEmpty.equals("All")) {
                        collection.clear();
                    } else {
                        if (collection.containsKey(usernameEmpty)) {
                            collection.remove(usernameEmpty);
                        }
                    }
            }
            line = scanner.nextLine();
        }
        System.out.println("Users count: " + collection.size());
        collection.entrySet().stream()
                .sorted((f, s) -> {
                    int received = s.getValue()[1] - f.getValue()[1];
                    if (received == 0) {
                        return f.getKey().compareTo(s.getKey());
                    } else {
                        return received;
                    }
                })
                .forEach((entry) -> System.out.println(entry.getKey() + " - " + (entry.getValue()[0] + entry.getValue()[1])));
    }
}
