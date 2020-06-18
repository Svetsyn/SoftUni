package shopping_spree;

import shopping_spree.Person;
import shopping_spree.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = Arrays.stream(scanner.nextLine().split(";"))
                .map(p -> {
                    String[] data = p.split("=");
                    return new Person(data[0], Double.parseDouble(data[1]));
                })
                .collect(Collectors.toList());

        List<Product> product = Arrays.stream(scanner.nextLine().split(";"))
                .map(p -> {
                    String[] store = p.split("=");
                    return new Product(store[0], Double.parseDouble(store[1]));
                })
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] date = input.split(" ");

            for (Person person : people) {
                if (person.getName().equals(date[0])) {
                    Product product1 = null;
                    for (Product p : product) {
                        if (p.getName().equals(date[1])) {
                            product1 = p;
                            break;
                        }
                    }
                    if (product1 != null) {

                        try {
                            person.buyProduct(product1);
                            System.out.printf("%s bought %s%n", person.getName(), product1.getName());
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                }

            }
            input = scanner.nextLine();
        }


        for (Person person : people) {
            System.out.println(person);
        }
    }
}