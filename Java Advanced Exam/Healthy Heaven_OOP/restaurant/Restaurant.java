package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> date;

    public Restaurant(String name){
        this.name = name;
        this.date = new ArrayList<>();
    }
    public void add(Salad salad){
        this.date.add(salad);
    }
    public boolean buy(String name){
        boolean isBought=this.date.removeIf(e->e.getName().equals(name));
        return isBought;
    }
    public String getHealthiestSalad(){
        Salad salad=this.date.stream().sorted((f, s)->f.getTotalCalories()-s.getTotalCalories()).findFirst().orElse(null);
        return salad.getName();
    }
    public String generateMenu(){
        StringBuilder sb =new StringBuilder(String.format("%s have %d salads:%n",this.name,this.date.size()));
        for (Salad salad : this.date) {
            sb.append(salad).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
