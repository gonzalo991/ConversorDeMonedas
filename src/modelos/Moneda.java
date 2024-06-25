package modelos;

public record Moneda(String time_last_update_utc, String base_code,
                     String target_code, float conversion_rate, float conversion_result) {
}
