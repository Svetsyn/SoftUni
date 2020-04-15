package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.capacity > this.data.size()) {
            this.data.add(egg);
        }
    }
    public boolean removeEgg(String color){
        boolean removed = this.data.removeIf(e->e.getColor().equals(color));

        return removed;
    }

    public Egg getStrongestEgg(){
        Egg strongest =this.data.stream()
                .sorted((f,s)->s.getStrength()-f.getStrength())
                .findFirst().orElse(null);
        return strongest;
    }
    public Egg getEgg(String color){
        Egg get= this.data.stream().filter(e->e.getColor().equals(color)).findFirst().orElse(null);
        return get;
    }
    public int getCount(){
        int sum =this.data.size();
        return sum;
    }
    public String report(){
        StringBuilder sb=new StringBuilder(String.format("%s basket contains:%n",this.material));
        for (Egg egg : data) {
            sb.append(egg).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
