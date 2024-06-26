package enums;

/**
 * Enumeración que representa las posibles conversiones de temperatura.
 */
public enum ConversionesDeTemperatura {
    CELSIUS_A_KELVIN("Celsius a Kelvin"),
    CELSIUS_A_FAHRENHEIT("Celsius a Fahrenheit"),
    KELVIN_A_CELSIUS("Kelvin a Celsius"),
    KELVIN_A_FAHRENHEIT("Kelvin a Fahrenheit"),
    FAHRENHEIT_A_CELSIUS("Fahrenheit a Celsius"),
    FAHRENHEIT_A_KELVIN("Fahrenheit a Kelvin");

    private final String descripcion;

    /**
     * Constructor para la enumeración de conversiones de temperatura.
     * @param descripcion Descripción de la conversión.
     */
    ConversionesDeTemperatura(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción de la conversión.
     * @return La descripción de la conversión.
     */
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}