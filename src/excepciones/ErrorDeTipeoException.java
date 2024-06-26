package excepciones;

/**
 * Excepción personalizada para manejar errores de tipeo.
 */
public class ErrorDeTipeoException extends NumberFormatException {

    private String mensaje;

    /**
     * Constructor que inicializa la excepción con un mensaje específico.
     *
     * @param mensaje Mensaje de error que describe la razón del error de tipeo.
     */
    public ErrorDeTipeoException(String mensaje) {
        // Aquí deberías asignar el mensaje que recibe como parámetro, no un mensaje fijo.
        this.mensaje = mensaje;
    }

    /**
     * Obtiene el mensaje de error asociado con esta excepción.
     *
     * @return Mensaje de error detallado.
     */
    @Override
    public String getMessage() {
        return this.mensaje;
    }
}