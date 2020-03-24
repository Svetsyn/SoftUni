package restaurant;

public class Vegetable {
    private String name;
    private int calories;

    public Vegetable(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return this.calories;
    }

    @Override
    public String toString() {
        return String.format(" - %s have %d calories", this.name, this.calories);
    }
}
