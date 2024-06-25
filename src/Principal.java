import excepciones.ErrorDeTipeoException;
import modelos.Moneda;
import servicio.ConversorDeMonedas;
import servicio.GeneradorDeArchivos;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        Object[] possibleValues = { "Conversor de monedas", "Conversor de temperatura" };

        Object selectedValue = JOptionPane.showInputDialog(null,
                "Seleccione una opción de conversión", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);

        if(selectedValue.equals("Conversor de monedas")){
            try {

                ConversorDeMonedas consulta = new ConversorDeMonedas();

                String source = JOptionPane.showInputDialog("Digite 3 letras para la moneda a convertir: \n" +
                        "(EJ: ARS , EUR, USD)", null);
                String target = JOptionPane.showInputDialog("Digite 3 letras de la moneda seleccionada para la conversión: \n" +
                        "(EJ: ARS , EUR, USD)", null);
                 int quantity = Integer.parseInt(
                        JOptionPane.showInputDialog("Digite la cantidad de "+ source+" a convertir: ", null)
                );

                Moneda moneda = consulta.convertirMoneda(source, target, quantity);
                double valorConvertido = moneda.amount();

                String respuesta = String.format("La cantidad convertida es: %.2f %s", valorConvertido, target);

                JOptionPane.showMessageDialog(null, respuesta);

                GeneradorDeArchivos generador = new GeneradorDeArchivos();
                generador.guardarConsultaMoneda(moneda);

                System.out.println("Finalizó la conversión.");

            }catch(ErrorDeTipeoException e){
                System.out.println(e.getMessage());
            } catch(RuntimeException e) {
                System.out.println("Ocurrio un error. Revise la URI." + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: "+ e.getMessage());
            }

        } else if(selectedValue.equals("Conversor de temperatura")){
            System.out.println(selectedValue);
        }
    }
}
