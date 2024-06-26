package utils;
import enums.ConversionesDeTemperatura;
import modelos.Temperatura;
import javax.swing.*;

public class UtilsTemperatura {
    /**
     * Solicita al usuario que ingrese una tasa de conversión numérica y valida la entrada.
     *
     * Mientras el usuario no ingrese un valor numérico válido, muestra un mensaje de error
     * y solicita nuevamente la entrada.
     *
     * @return La tasa de conversión ingresada por el usuario como un número de tipo double.
     */
    private static double obtenerValorEnGrados() {
        double valorEnGrados;

        // Bucle infinito para manejar la entrada del usuario hasta que ingrese un valor válido.
        while (true) {
            // Solicitar al usuario que ingrese la tasa de conversión como una cadena.
            String input = JOptionPane.showInputDialog(null,
                    "Ingresa la cantidad de grados que deseas convertir:", null);

            try {
                // Intentar convertir la cadena ingresada a un número flotante.
                valorEnGrados = Double.parseDouble(input);
                break;  // Salir del bucle si la conversión fue exitosa.
            } catch (NumberFormatException e) {
                // Capturar la excepción si la entrada no es numérica.
                JOptionPane.showMessageDialog(null,
                        "Error: Ingresa un valor numérico válido para la conversión.",
                        "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
        return valorEnGrados;
    }

    public static Temperatura getTemperatura (ConversionesDeTemperatura conversionElegida, double valor){
        Temperatura temperatura = new Temperatura();

        switch(conversionElegida){
            case CELSIUS_A_KELVIN:
                temperatura.convertirCelsiusAKelvin(valor);
                break;
            case CELSIUS_A_FAHRENHEIT:
                temperatura.convertirCelsiusAFahrenheit(valor);
                break;
            case KELVIN_A_CELSIUS:
                temperatura.convertirKelvinACelsius(valor);
                break;
            case KELVIN_A_FAHRENHEIT:
                temperatura.convertirKelvinAFahrenheit(valor);
                break;
            case FAHRENHEIT_A_CELSIUS:
                temperatura.convertirFahrenheitACelsius(valor);
                break;
            case FAHRENHEIT_A_KELVIN:
                temperatura.convertirCelsiusAKelvin(valor);
                break;
        }
        return temperatura;
    }

    private static void ejecutarConversionDeTemperaturas(){
        String escala = null;
        double valorConvertido;
        String respuesta = null;
        Temperatura resultado = new Temperatura();

        ConversionesDeTemperatura[] conversiones = ConversionesDeTemperatura.values();
        double valorEnGrados = obtenerValorEnGrados();

        ConversionesDeTemperatura conversionElegida = (ConversionesDeTemperatura) JOptionPane
                .showInputDialog(null,
                        "Selecciona la moneda a la que deseas convertir tu dinero: ",
                        "Monedas", JOptionPane.INFORMATION_MESSAGE,
                        null, conversiones, conversiones[0]);

        resultado = getTemperatura(conversionElegida, valorEnGrados);
        valorConvertido = resultado.getValorEnGrados();
        escala = resultado.getEscala();
        // Construir un mensaje con el resultado de la conversión
        respuesta = String.format("La cantidad convertida es: %.2f, Grados %s", valorConvertido, escala);
    }
}
