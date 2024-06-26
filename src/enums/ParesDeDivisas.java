package enums;

/**
 * Enumeración que representa diferentes pares de divisas para conversiones.
 */
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

    /**
     * Constructor privado de ParesDeDivisas.
     *
     * @param from Código de la moneda de origen.
     * @param to   Código de la moneda de destino.
     */
    ParesDeDivisas(String from, String to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Obtiene el código de la moneda de origen.
     *
     * @return Código de la moneda de origen.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Obtiene el código de la moneda de destino.
     *
     * @return Código de la moneda de destino.
     */
    public String getTo() {
        return to;
    }
}
