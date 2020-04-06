import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int claimBox = 0;

        ArrayDeque<Integer> stack = parsToStack(first);
        ArrayDeque<Integer> queue = parsToQueue(second);

        while (!(stack.isEmpty() || queue.isEmpty())) {
            int currentFirst = stack.peek();
            int currentSecond = queue.peek();
            int sum = currentFirst + currentSecond;
            if (sum % 2 == 0) {
                claimBox += sum;
                stack.pop();
                queue.remove();
            } else {
                queue.remove();
                List<Integer> removerOdd = new ArrayList<>();

                while (!stack.isEmpty()) {
                    removerOdd.add(stack.pop());
                }
                removerOdd.add(currentSecond);
                for (int i = removerOdd.size() - 1; i >= 0; i--) {
                    stack.push(removerOdd.get(i));
                }
            }
        }
            if (stack.isEmpty()){
                System.out.println("First lootbox is empty");
            }else {
                System.out.println("Second lootbox is empty");
            }
            if (claimBox>=100){
                System.out.printf("Your loot was epic! Value: %d%n",claimBox);
            }else {
                System.out.printf("Your loot was poor... Value: %d%n",claimBox);
            }


    }

    private static ArrayDeque<Integer> parsToQueue(int[] second) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = second.length - 1; i >= 0; i--) {
            queue.offer(second[i]);
        }
        return queue;
    }

    private static ArrayDeque<Integer> parsToStack(int[] first) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = first.length - 1; i >= 0; i--) {//10 11 8 13 5 6
            stack.push(first[i]);
        }
        return stack;
    }
}
