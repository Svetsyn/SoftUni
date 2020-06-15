package stack;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos =new StackOfStrings();

        System.out.println(sos.isEmpty());
        sos.push("1");
        sos.push("2");
        sos.push("3");
        sos.push("4");

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.peek());
        System.out.println(sos.isEmpty());
    }
}
