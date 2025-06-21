package Service;

import Repository.CurrencyRepository;
import Model.ExchangeRateResponse;

import java.io.IOException;
import java.util.Set;

public class CurrencyConverterService {
    private final CurrencyRepository apiClient;

    public CurrencyConverterService(CurrencyRepository apiClient) {
        this.apiClient = new CurrencyRepository();
    }

    public Set<String> getAvailableCurrencies(String baseCurrency) throws IOException, InterruptedException {
        ExchangeRateResponse response = apiClient.getExchangeRate(baseCurrency);
        return response.rates().keySet();
    }


    public double convertCurrency(String sourceCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        ExchangeRateResponse exchangeRateResponse = apiClient.getExchangeRate(sourceCurrency);
        Double conversionRate = exchangeRateResponse.rates().get(targetCurrency);

        if (conversionRate == null) {
            throw new IllegalArgumentException("Moeda de destino inválida");
        }

        return amount * conversionRate;
    }
}
