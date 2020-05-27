import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collection = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            collection.add(num);
        }
        Collections.sort(collection);
        Collections.reverse(collection);
        for (Integer integer : collection) {
            System.out.println(integer);
        }
    }
}