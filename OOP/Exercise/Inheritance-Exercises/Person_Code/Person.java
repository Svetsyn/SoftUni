package person;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
   // private List<String> date;

    public Person(String name, int age) {
        this.name=name;
        this.age =age;
        //this.date = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

//    public List<String> getDate() {
//        return date;
//    }
}
