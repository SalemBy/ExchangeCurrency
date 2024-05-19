import model.Converter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Converter converter = new Converter();
        double value = 0.0, ansValue = 0.0;


        while (true) {
            System.out.println("Enter an option:");
            System.out.println("1. USD to EUR");
            System.out.println("2. EUR to USD");
            System.out.println("3. USD to GBP");
            System.out.println("4. GBP to USD");
            System.out.println("5. GBP to EUR");
            System.out.println("6. EUR to GBP");
            System.out.println("7. Exit");
            choice = sc.nextInt();

            if (choice == 7) {
                break;
            }

            System.out.println("How many units do you want to convert?");
            value = sc.nextDouble();

            ansValue = switch (choice) {
                case 1 -> converter.compareCurrency("USD", "EUR", value);
                case 2 -> converter.compareCurrency("EUR", "USD", value);
                case 3 -> converter.compareCurrency("USD", "GBP", value);
                case 4 -> converter.compareCurrency("GBP", "USD", value);
                case 5 -> converter.compareCurrency("GBP", "EUR", value);
                case 6 -> converter.compareCurrency("EUR", "GBP", value);
                default -> ansValue;
            };

            System.out.println("Converted value: " + ansValue);

        }
    }
}