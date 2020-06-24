package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> URLs;

    public Smartphone(List<String> numbers, List<String> URLs) {
        this.numbers = numbers;
        this.URLs = URLs;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : URLs) {
            boolean isValidURLs = validURLs(url);
            if (isValidURLs){
                sb.append("Browsing: ");
                sb.append(url);
                sb.append("!");
            }else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private boolean validURLs(String url) {
        for (char symbol : url.toCharArray()) {
            if (Character.isDigit(symbol)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
            boolean isValid = validNumberInput(number);
            if (isValid) {
                sb.append("Calling... ").append(number);
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }



    private boolean validNumberInput(String number) {
        for (char num : number.toCharArray()) {
            if (!Character.isDigit(num)) {
                return false;
            }
        }
        return true;
    }
}
