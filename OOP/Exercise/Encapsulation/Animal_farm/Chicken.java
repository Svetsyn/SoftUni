package animal_farm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {

            this.name = name;
        }

    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggs = 0.00;
        if (this.age <= 5.00) {
            eggs = 2.00;
        } else if (this.age > 5.00 && this.age <= 11.00) {
            eggs = 1.00;
        } else {
            eggs = 0.75;
        }

        return eggs;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day."
                , this.name
                , this.age
                , calculateProductPerDay());
    }
}
