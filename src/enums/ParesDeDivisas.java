package enums;

public enum ParesDeDivisas {
    PESOS_A_DOLAR("ARS", "USD"),
    PESOS_A_EURO("ARS", "EUR"),
    PESOS_A_LIBRAS("ARS", "GBP"),
    PESOS_A_YEN("ARS", "JPY"),
    PESOS_A_WON_COREANO("ARS", "KRW"),
    DOLAR_A_PESOS("USD", "ARS"),
    EURO_A_PESOS("EUR", "ARS"),
    LIBRAS_A_PESOS("GBP", "ARS"),
    YEN_A_PESOS("JPY", "ARS"),
    WON_COREANO_A_PESOS("KRW", "ARS");

    private String from;
    private String to;

    ParesDeDivisas(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
