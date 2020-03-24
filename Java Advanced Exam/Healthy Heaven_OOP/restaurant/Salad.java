package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (int i = 0; i < this.products.size(); i++) {
            int currentCalories = this.products.get(i).getCalories();
            totalCalories += currentCalories;
        }
        return totalCalories;
    }
    public int getProductCount(){
        return this.products.size();
    }
    public void add(Vegetable product){
        this.products.add(product);
    }
    @Override
    public String toString(){
        StringBuilder sb =new StringBuilder(String.format("* Salad %s is %d calories and have %d products:%n",this.name,this.getTotalCalories(),this.getProductCount()));
        for (Vegetable vegetable : this.products) {
            sb.append(vegetable).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
