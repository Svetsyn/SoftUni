package rabbits;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cage cage = new Cage("Wildness", 20);
        Rabbit rabbit = new Rabbit("Fluffy", "Blanc de Hotot");
        System.out.println(rabbit);

        cage.add(rabbit);
        System.out.println(cage.count());
        System.out.println(cage.removeRabbit("Rabbit name"));

        Rabbit secondRabbit = new Rabbit("Bunny", "Brazilian");
        Rabbit thirdRabbit = new Rabbit("Jumpy", "Cashmere Lop");
        Rabbit fourthRabbit = new Rabbit("Puffy", "Cashmere Lop");
        Rabbit fifthRabbit = new Rabbit("Marlin", "Brazilian");

        cage.add(secondRabbit);
        cage.add(thirdRabbit);
        cage.add(fourthRabbit);
        cage.add(fifthRabbit);

        System.out.println(cage.sellRabbit("Bunny"));
        List<Rabbit> soldSpecies =cage.sellRabbitBySpecies("Cashmere Lop");
        soldSpecies.forEach(f->{
            System.out.println(f.getName());
        });
        System.out.println(cage.report());
    }
}
