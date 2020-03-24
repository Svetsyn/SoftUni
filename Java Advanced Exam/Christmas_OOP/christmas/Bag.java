package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        boolean isRemove = this.data.removeIf(e -> e.getName().equals(name));
        return isRemove;
    }

    public Present heaviestPresent() {
        Present present = this.data.stream()
                .sorted((f,s)-> (int) (s.getWeight()-f.getWeight()))
                .findFirst()
                .orElse(null);
        return present;
    }

    public Present getPresent(String name) {
        Present present = null;
        for (int i = 0; i < this.data.size(); i++) {
            Present present1 = this.data.get(i);
            if (present1.getName().equals(name)) {
                present = present1;
                break;
            }
        }
        return present;
    }
    public String report(){
        StringBuilder sb=new StringBuilder(String.format("%s bag contains:%n",this.color));
        for (Present datum : this.data) {
            sb.append(datum).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
