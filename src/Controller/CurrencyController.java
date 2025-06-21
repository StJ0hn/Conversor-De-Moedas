package Controller;

import Repository.CurrencyRepository;
import Service.CurrencyConverterService;
import View.CurrencyConverterView;

import java.io.IOException;

public class CurrencyController {

    private final CurrencyConverterService converterService;

    public CurrencyController(CurrencyConverterView view, CurrencyConverterService service) {
        CurrencyRepository apiClient = null;
        this.converterService = new CurrencyConverterService(apiClient);
    }

    public double convert(String sourceCurrency, String targetCurrency, double amount) {
        try {
            return converterService.convertCurrency(sourceCurrency, targetCurrency, amount);
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consultar a API: " + e.getMessage());
            return -1;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na conversão: " + e.getMessage());
            return -1;
        }
    }
}
