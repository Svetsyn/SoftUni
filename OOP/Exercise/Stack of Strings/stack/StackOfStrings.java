package stack;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        return this.data.remove(getLastIndex());
    }

    private int getLastIndex() {
        return this.data.size() - 1;
    }

    public String peek() {
        return this.data.get(getLastIndex());
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
