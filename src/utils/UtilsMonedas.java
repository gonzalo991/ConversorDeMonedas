package utils;

import enums.ConversionDeMonedas;
import enums.ParesDeDivisas;
import excepciones.ErrorDeTipeoException;
import modelos.Moneda;
import servicio.Conversor;
import servicio.GeneradorDeArchivos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UtilsMonedas {
    /**
     * Solicita al usuario que ingrese una tasa de conversión numérica y valida la entrada.
     *
     * Mientras el usuario no ingrese un valor numérico válido, muestra un mensaje de error
     * y solicita nuevamente la entrada.
     *
     * @return La tasa de conversión ingresada por el usuario como un número de tipo float.
     */
    public static float obtenerConversionRate() {
        float conversion_rate;

        // Bucle infinito para manejar la entrada del usuario hasta que ingrese un valor válido.
        while (true) {
            // Solicitar al usuario que ingrese la tasa de conversión como una cadena.
            String input = JOptionPane.showInputDialog(null,
                    "Ingresa la cantidad de dinero que deseas convertir:", null);

            try {
                // Intentar convertir la cadena ingresada a un número flotante.
                conversion_rate = Float.parseFloat(input);
                break;  // Salir del bucle si la conversión fue exitosa.
            } catch (NumberFormatException e) {
                // Capturar la excepción si la entrada no es numérica.
                JOptionPane.showMessageDialog(null,
                        "Error: Ingresa un valor numérico válido para la tasa de conversión.",
                        "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        }

        return conversion_rate;  // Devolver la tasa de conversión como float.
    }

    /**
     * Método para ejecutar la conversión de monedas, interactuando con el usuario mediante ventanas de diálogo.
     */
    public static void ejecutarConversionDeMonedas() {
        try {
            String base_code = null;
            String target_code = null;

            Conversor consulta = new Conversor();
            ConversionDeMonedas[] conversiones = ConversionDeMonedas.values();

            // Solicitar al usuario que ingrese la cantidad de dinero a convertir
            float conversion_rate = obtenerConversionRate();

            // Mostrar un cuadro de diálogo para que el usuario seleccione el tipo de conversión de moneda
            ConversionDeMonedas monedas = (ConversionDeMonedas) JOptionPane
                    .showInputDialog(null,
                            "Selecciona la moneda a la que deseas convertir tu dinero: ",
                            "Monedas", JOptionPane.INFORMATION_MESSAGE,
                            null, conversiones, conversiones[0]);

            // Obtener la lista de pares de divisas asociados con la conversión seleccionada
            List<ParesDeDivisas> pares = getParesDeDivisas(monedas);

            // Iterar sobre los pares de divisas (aunque probablemente solo haya uno)
            for (ParesDeDivisas par : pares) {
                base_code = par.getFrom().toUpperCase(); // Código de moneda de origen en mayúsculas
                target_code = par.getTo().toUpperCase(); // Código de moneda de destino en mayúsculas
            }


            // Realizar la conversión de moneda utilizando el servicio Conversor
            Moneda moneda = consulta.convertirMoneda(base_code, target_code, conversion_rate);
            double valorConvertido = moneda.conversion_result();

            // Construir un mensaje con el resultado de la conversión
            String respuesta = String.format("La cantidad convertida es: %.2f %s", valorConvertido, target_code);

            // Mostrar el resultado de la conversión en una ventana de diálogo
            JOptionPane.showMessageDialog(null, respuesta);

            // Generar un archivo JSON con los detalles de la consulta de conversión
            GeneradorDeArchivos generador = new GeneradorDeArchivos();
            generador.guardarConsultaMoneda(moneda);

            // Mensaje de confirmación en consola
            System.out.println("Finalizó la conversión.");

        } catch (ErrorDeTipeoException e) {
            // Capturar y manejar excepción específica si ocurre un error de tipeo
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            // Capturar y manejar excepción general si ocurre un error en tiempo de ejecución
            System.out.println("Ocurrió un error. Revise la URI: " + e.getMessage());
        } catch (Exception e) {
            // Capturar y manejar cualquier otra excepción inesperada
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }


    /**
     * Obtiene la lista de pares de divisas asociados con una conversión de moneda específica.
     *
     * @param moneda Tipo de conversión de moneda seleccionada.
     * @return Lista de pares de divisas asociados con la conversión de moneda.
     */

    public static List<ParesDeDivisas> getParesDeDivisas(ConversionDeMonedas moneda) {
        List<ParesDeDivisas> pares = new ArrayList<>();

        // Determinar qué pares de divisas están asociados con la conversión de moneda seleccionada
        switch (moneda) {
            case PESOS_A_DOLAR:
                pares.add(ParesDeDivisas.PESOS_A_DOLAR);
                break;
            case PESOS_A_EURO:
                pares.add(ParesDeDivisas.PESOS_A_EURO);
                break;
            case PESOS_A_LIBRAS:
                pares.add(ParesDeDivisas.PESOS_A_LIBRAS);
                break;
            case PESOS_A_YEN:
                pares.add(ParesDeDivisas.PESOS_A_YEN);
                break;
            case PESOS_A_WON_COREANO:
                pares.add(ParesDeDivisas.PESOS_A_WON_COREANO);
                break;
            case DOLAR_A_PESOS:
                pares.add(ParesDeDivisas.DOLAR_A_PESOS);
                break;
            case EURO_A_PESOS:
                pares.add(ParesDeDivisas.EURO_A_PESOS);
                break;
            case LIBRAS_A_PESOS:
                pares.add(ParesDeDivisas.LIBRAS_A_PESOS);
                break;
            case YEN_A_PESOS:
                pares.add(ParesDeDivisas.YEN_A_PESOS);
                break;
            case WON_COREANO_A_PESOS:
                pares.add(ParesDeDivisas.WON_COREANO_A_PESOS);
                break;
        }
        return pares;
    }
}