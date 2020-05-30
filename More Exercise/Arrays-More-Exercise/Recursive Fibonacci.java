import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        long[] fibonacci = new long[input];

        if (input >= 1 && input <= 50) {
            for (int i = 0; i < input; i++) {
                if (i==0 || i==1){
                    fibonacci[i]=1;
                }else {
                    fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
                }
            }
            System.out.println(fibonacci[input - 1]);
        }else {
            System.out.println(input);
        }
    }
}