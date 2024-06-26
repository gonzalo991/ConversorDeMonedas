package enums;

/**
 * Enumeración que representa los pares de conversiones de temperatura.
 */
public enum ParesDeTemperatura {
    CELSIUS_A_KELVIN("Celsius", "Kelvin"),
    CELSIUS_A_FAHRENHEIT("Celsius", "Fahrenheit"),
    KELVIN_A_CELSIUS("Kelvin", "Celsius"),
    KELVIN_A_FAHRENHEIT("Kelvin", "Fahrenheit"),
    FAHRENHEIT_A_CELSIUS("Fahrenheit", "Celsius"),
    FAHRENHEIT_A_KELVIN("Fahrenheit", "Kelvin");

    private String from;
    private String to;

    /**
     * Constructor para la enumeración de pares de conversiones de temperatura.
     * @param from Escala de origen.
     * @param to Escala de destino.
     */
    ParesDeTemperatura(String from, String to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Obtiene la escala de origen.
     * @return La escala de origen.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Obtiene la escala de destino.
     * @return La escala de destino.
     */
    public String getTo() {
        return to;
    }
}
