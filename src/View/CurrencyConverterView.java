package View;

import Controller.CurrencyController;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class CurrencyConverterView {

    private final CurrencyController controller;
    private final Scanner scanner = new Scanner(System.in);

    public CurrencyConverterView() {
        this.controller = new CurrencyController();
    }

    private String requestValidCurrency(String message, Set<String> availableCurrencies) {
        String currency;
        while (true) {
            System.out.print(message);
            currency = scanner.nextLine().toUpperCase();

            if (availableCurrencies.contains(currency)) {
                break;
            } else {
                System.out.println("Invalid currency! Available options: " + availableCurrencies);
            }
        }
        return currency;
    }

    public void start() {
        System.out.println("=== Currency Converter ===");

        try {
            Set<String> availableCurrencies = controller.getAvailableCurrencies("USD");

            String sourceCurrency = requestValidCurrency("Enter source currency (e.g., USD): ", availableCurrencies);
            String targetCurrency = requestValidCurrency("Enter target currency (e.g., BRL): ", availableCurrencies);

            System.out.print("Enter amount to convert: ");
            double amount = Double.parseDouble(scanner.nextLine());

            double result = controller.convert(sourceCurrency, targetCurrency, amount);

            if (result >= 0) {
                System.out.printf("Result: %.2f %s equals %.2f %s%n", amount, sourceCurrency, result, targetCurrency);
            } else {
                System.out.println("Conversion failed. Please try again.");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("API error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount! Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        new CurrencyConverterView().start();
    }
}
