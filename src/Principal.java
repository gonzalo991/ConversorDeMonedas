import enums.ParesDeDivisas;
import excepciones.ErrorDeTipeoException;
import enums.ConversionDeMonedas;
import modelos.Moneda;
import enums.OpcionesDeConversion;
import servicio.Conversor;
import servicio.GeneradorDeArchivos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que maneja la interfaz de usuario para convertir monedas o temperaturas.
 */
public class Principal {

    /**
     * Método principal que inicia la interfaz de usuario para seleccionar y ejecutar conversiones.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        do {
            OpcionesDeConversion[] opciones = OpcionesDeConversion.values();

            // Mostrar un cuadro de diálogo para que el usuario seleccione una opción de conversión
            Object selectedValue = JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción de conversión",
                    "Input",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            // Verificar qué opción fue seleccionada
            if (selectedValue == OpcionesDeConversion.CONVERSOR_DE_MONEDAS) {
                ejecutarConversionDeMonedas();

                // Preguntar al usuario si desea continuar o terminar
                int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?",
                        "Select an option", JOptionPane.YES_NO_CANCEL_OPTION);

                if (confirm != JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa terminado.");
                    break;
                }
            } else if (selectedValue == OpcionesDeConversion.CONVERSOR_DE_TEMPERATURA) {
                System.out.println(selectedValue);
            } else {
                JOptionPane.showMessageDialog(null, "Programa terminado.");
                break;
            }

        } while (true);
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

    /**
     * Método para ejecutar la conversión de monedas, interactuando con el usuario mediante ventanas de diálogo.
     */
    public static void ejecutarConversionDeMonedas() {
        try {
            String base_code = null;
            String target_code = null;

            Conversor consulta = new Conversor();
            ConversionDeMonedas[] conversiones = ConversionDeMonedas.values();

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

            // Solicitar al usuario que ingrese la cantidad de dinero a convertir
            float conversion_rate = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Ingresa la cantidad de dinero que deseas convertir:", null));

            // Mostrar en consola los valores seleccionados para la conversión
            System.out.println("Valores: " + base_code + ", " + target_code + ", " + conversion_rate);

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
}