package View;

import Controller.CurrencyController;
import Service.CurrencyConverterService;

import java.util.Scanner;

public class CurrencyConverterView {

    private final CurrencyController controller;

    public CurrencyConverterView() {
        CurrencyConverterView view = null;
        CurrencyConverterService service = null;
        this.controller = new CurrencyController(view, service);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Conversor de Moedas ===");

        System.out.print("Digite a moeda de origem (ex: USD): ");
        String sourceCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Digite a moeda de destino (ex: BRL): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Digite o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        double result = controller.convert(sourceCurrency, targetCurrency, amount);

        if (result >= 0) {
            System.out.printf("Resultado: %.2f %s equivalem a %.2f %s%n", amount, sourceCurrency, result, targetCurrency);
        } else {
            System.out.println("Falha na conversão. Tente novamente.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new CurrencyConverterView().start();
    }
}
