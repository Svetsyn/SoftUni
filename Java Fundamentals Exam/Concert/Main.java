import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> collection = new LinkedHashMap<>();
        Map<String, Integer> timer = new TreeMap<>();
        String line = scanner.nextLine();

        while (!line.equals("start of concert")) {
            String[] token = line.split("; ");
            String command = token[0];
            String band = token[1];

            switch (command) {
                case "Add":
                    String[] members = token[2].split(", ");
                    if (!(collection.containsKey(band))) {
                        collection.put(band, new ArrayList<>());
                        for (String member : members) {
                            if (!collection.get(band).contains(member)) {
                                collection.get(band).add(member);
                            }
                        }
                    } else {
                        for (String member : members) {
                            if (!collection.get(band).contains(member)) {
                                collection.get(band).add(member);
                            }
                        }
                    }
                    timer.putIfAbsent(band, 0);
                    break;
                case "Play":
                    int time = Integer.parseInt(token[2]);
                    if (!(collection.containsKey(band))) {
                        collection.put(band, new ArrayList<>());
                        timer.put(band, time);
                    } else {
                        timer.put(band, timer.get(band) + time);
                    }
            }
            line = scanner.nextLine();
        }
        String finalName=scanner.nextLine();

        int sum = 0;
        for (Integer integer : timer.values()) {
            sum += integer;
        }
        System.out.println("Total time: " + sum);
        String name = "";
        timer.entrySet().stream().sorted((n1, n2) -> n2.getValue() - n1.getValue())
                .forEach((entry) -> System.out.println(entry.getKey() + " -> " + entry.getValue())
                );
        String nameFirst = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : timer.entrySet()) {
            String currentName = entry.getKey();
            int currentTime = entry.getValue();
            if (currentTime > max) {
                max = currentTime;
                nameFirst = currentName;
            }
        }
        System.out.println(finalName);

        for (Map.Entry<String, List<String>> entry : collection.entrySet()) {
            String currentName = entry.getKey();
            List<String> currentList = entry.getValue();
            int index = 0;
            if (currentName.equals(finalName)) {
                for (int i = 0; i < currentList.size(); i++) {
                    System.out.println("=> " + currentList.get(i));
                }
                index++;
                break;
            }
            if (index != 0) {
                break;
            }
        }

    }
}
