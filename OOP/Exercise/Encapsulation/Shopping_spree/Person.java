package shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> product;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.product = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public void buyProduct(Product product) {
        if (this.money>=product.getCost()){
            this.money-=product.getCost();
            this.product.add(product);
        }else {
            throw new IllegalStateException(String.format("%s can't afford %s",this.getName()
            ,product.getName()));
        }
    }

    @Override
    public String toString() {
        String outut = "Nothing bought";
        if (!this.product.isEmpty()){
            outut=this.product.stream().map(p->p.getName())
                    .collect(Collectors.joining(", "));
        }
        return this.getName()+" - "+outut;
    }
}

