package Model;

import java.util.Map;

public record ExchangeRateResponse(String time_last_update_utc, String time_next_update_utc, String base_code, Map<String, Double> rates) {}
