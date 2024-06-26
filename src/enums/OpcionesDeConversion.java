package enums;

/**
 * Enumeración que representa opciones de conversión disponibles.
 */
public enum OpcionesDeConversion {
    CONVERSOR_DE_MONEDAS("Conversor de monedas"),
    CONVERSOR_DE_TEMPERATURA("Conversor de temperatura");

    private String descripcion;

    /**
     * Constructor privado de OpcionesDeConversion.
     *
     * @param descripcion La descripción de la opción de conversión.
     */
    OpcionesDeConversion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción asociada con la opción de conversión.
     *
     * @return La descripción de la opción de conversión.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sobrescribe el método toString para devolver la descripción de la opción de conversión.
     *
     * @return La descripción de la opción de conversión.
     */
    @Override
    public String toString() {
        return descripcion;
    }

    /**
     * Ejemplo de uso: método estático para imprimir todas las descripciones de las opciones de conversión.
     */
}