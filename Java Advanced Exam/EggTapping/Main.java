import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split("\\s+");
        String[] second = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = parsToStack(first);
        ArrayDeque<String> queue = parsToQueue(second);

        int firstScore = 0;
        int secondScore = 0;

        while (!(stack.isEmpty() || queue.isEmpty())) {

            String currentStack = stack.pop();
            String currentQueue = queue.remove();

            char valueStack = currentStack.charAt(0);
            char valueQueu = currentQueue.charAt(0);
            if (valueStack < valueQueu) {
                char winSymbol = (char) (valueStack + 1);
                firstScore += valueQueu;
                //stack.pop();
                List<String> currentCollection = new ArrayList<>();
                while (!stack.isEmpty()) {
                    currentCollection.add(stack.pop());
                }
                String currentWinSymbol = String.valueOf(winSymbol);
                currentCollection.add(currentWinSymbol);
                for (int i = currentCollection.size() - 1; i >= 0; i--) {
                    stack.push(currentCollection.get(i));
                }

            } else if (valueQueu < valueStack) {
                char winSymbol = (char) (valueQueu + 1);
                secondScore += valueStack;
                List<String> currentCollection = new ArrayList<>();
                String currentWinSymbol = String.valueOf(winSymbol);
                currentCollection.add(currentWinSymbol);
                while (!queue.isEmpty()) {
                    currentCollection.add(queue.remove());
                }
                for (int i = 0; i < currentCollection.size(); i++) {
                    queue.offer(currentCollection.get(i));
                }
            }
        }
        if (firstScore > secondScore) {
            System.out.printf("The winner ends with %d points.%n", firstScore);
            System.out.print("There are ");
            List<String> helper = new ArrayList<>();
            while (!stack.isEmpty()) {
                helper.add(stack.pop());
            }
            System.out.print(String.join(", ", helper));
            System.out.println(" in his collection.");

        } else if (secondScore > firstScore) {
            System.out.printf("The winner ends with %d points.%n", secondScore);

            System.out.print("There are ");
            List<String> helper = new ArrayList<>();
            while (!queue.isEmpty()) {
                helper.add(queue.remove());
            }
            System.out.print(String.join(", ", helper));
            System.out.println(" in his collection.");
        } else {
            System.out.println("Draw! Nobody wins.");
        }


    }

    private static ArrayDeque<String> parsToQueue(String[] second) {
        ArrayDeque<String> queue = new ArrayDeque<>();//a k e p q
        for (int i = second.length - 1; i >= 0; i--) {
            queue.offer(second[i]);
        }
        return queue;
    }

    private static ArrayDeque<String> parsToStack(String[] first) {
        ArrayDeque<String> stack = new ArrayDeque<>();//a k e p q
        for (int i = first.length - 1; i >= 0; i--) {
            stack.push(first[i]);
        }
        return stack;
    }
}