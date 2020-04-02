import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> collection = new TreeMap<>();

        String command;
        while (!"Log out".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "New":
                    String username = tokens[2];
                    collection.putIfAbsent(username, new int[2]);
                    break;
                case "Like:":
                    String usernameLike = tokens[1];
                    usernameLike = usernameLike.replace(":", "");
                    int count = Integer.parseInt(tokens[2]);
                    if (!collection.containsKey(usernameLike)) {
                        collection.put(usernameLike, new int[2]);
                        collection.get(usernameLike)[0] = count;
                    } else {
                        int currentCount = collection.get(usernameLike)[0];
                        collection.get(usernameLike)[0] = currentCount + count;
                    }
                    break;
                case "Comment:":
                    String usernameComment = tokens[1];
                    if (!collection.containsKey(usernameComment)) {
                        collection.put(usernameComment, new int[2]);
                        collection.get(usernameComment)[1] = 1;
                    } else {
                        int currentComments = collection.get(usernameComment)[1];
                        collection.get(usernameComment)[1] = currentComments + 1;
                    }
                    break;
                case "Blocked:":
                    String blockedUsername = tokens[1];
                    if (collection.containsKey(blockedUsername)) {
                        collection.remove(blockedUsername);
                    } else {
                        System.out.printf("%s doesn't exist.%n", blockedUsername);
                    }
                    break;
            }
        }
        System.out.printf("%d followers%n", collection.size());
        collection
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue()[0] - a.getValue()[0])
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()[0] + entry.getValue()[1]);
                });
    }

}
