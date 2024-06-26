import enums.OpcionesDeConversion;
import modelos.Temperatura;
import utils.UtilsMonedas;

import javax.swing.*;

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
                UtilsMonedas.ejecutarConversionDeMonedas();

                // Preguntar al usuario si desea continuar o terminar
                int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?",
                        "Select an option", JOptionPane.YES_NO_CANCEL_OPTION);

                if (confirm != JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa terminado.");
                    break;
                }
            } else if (selectedValue == OpcionesDeConversion.CONVERSOR_DE_TEMPERATURA) {
                Temperatura temperatura = new Temperatura();



            } else {
                JOptionPane.showMessageDialog(null, "Programa terminado.");
                break;
            }

        } while (true);
    }
}