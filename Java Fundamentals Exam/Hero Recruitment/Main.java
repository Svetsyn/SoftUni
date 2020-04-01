import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> collection = new TreeMap<>();
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("End")) {
            String[] token = line.split("\\s+");
            String command = token[0];
            switch (command) {
                case "Enroll":
                    String heroName = token[1];
                    if (!collection.containsKey(heroName)) {
                        collection.putIfAbsent(heroName, new ArrayList<>());
                    } else {
                        System.out.println(heroName + " is already enrolled.");
                    }
                    break;
                case "Learn":
                    String name = token[1];
                    String spelName = token[2];
                    if (!collection.containsKey(name)) {
                        System.out.println(name + " doesn't exist.");
                    } else {
                        if (collection.get(name).contains(spelName)) {
                            System.out.println(name + " has already learnt " + spelName + ".");
                        } else {
                            collection.get(name).add(spelName);
                        }
                    }
                    break;
                case "Unlearn":
                    String nameUnlearn = token[1];
                    String spelNameUnleran = token[2];

                    if (!collection.containsKey(nameUnlearn)) {
                        System.out.println(nameUnlearn + " doesn't exist.");
                    } else {
                        if (!collection.get(nameUnlearn).contains(spelNameUnleran)) {
                            System.out.printf("%s doesn't know %s.%n", nameUnlearn, spelNameUnleran);
                        } else {
                            for (Map.Entry<String, List<String>> entry : collection.entrySet()) {
                                String nameString = entry.getKey();
                                if (nameString.equals(nameUnlearn)) {
                                    List<String> listSpell = entry.getValue();
                                    int index = 0;
                                    for (int i = 0; i < listSpell.size(); i++) {
                                        if (listSpell.get(i).equals(spelNameUnleran)) {
                                            index = i;
                                            break;
                                        }
                                    }
                                    listSpell.remove(index);
                                    break;
                                }
                            }
                        }
                    }
            }
            line = scanner.nextLine();
        }
        System.out.println("Heroes:");
        collection.entrySet().stream()
                .sorted((f, s) -> {
                    int compare = s.getValue().size() - f.getValue().size();
                    if (compare == 0) {
                        return f.getKey().compareTo(s.getKey());
                    } else {
                        return compare;
                    }
                })
                .forEach((e) -> System.out.println("== " + e.getKey() + ": " + getPrintList(e.getValue())));
    }

    private static String getPrintList( List<String> e) {
        return e.toString().replaceAll("[\\[\\]]","");
    }
}

