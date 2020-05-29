import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] collection = new int[num];

        for (int i = 0; i < num; i++) {

            double sum = 0;
            char[] line = scanner.nextLine().toCharArray();
            for (int k = 0; k < line.length; k++) {
                if (line[k] == 'a' || line[k] == 'o' || line[k] == 'e' || line[k] == 'i'||line[k] == 'A'||line[k] == 'O'||line[k] == 'E'||line[k] == 'I'||line[k]=='u'||line[k]=='U') {
                    sum += (line[k] * line.length);
                } else {
                    sum += (line[k] / line.length);
                }
            }
            collection[i] += sum;
        }
        Arrays.stream(collection).sorted().forEach(e-> System.out.println(e));


    }
}