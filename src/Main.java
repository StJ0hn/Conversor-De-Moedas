import Controller.CurrencyController;
import Repository.CurrencyRepository;
import Service.CurrencyConverterService;
import View.CurrencyConverterView;

public class Main {
    public static void main(String[] args) {
        CurrencyRepository apiClient = new CurrencyRepository();
        CurrencyConverterService service = new CurrencyConverterService(apiClient);
        CurrencyConverterView view = new CurrencyConverterView();
        CurrencyController controller = new CurrencyController(view, service);

        view.start();

    }
}