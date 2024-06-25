import excepciones.ErrorDeTipeoException;
import modelos.ConversionDeMonedas;
import modelos.Moneda;
import modelos.OpcionesDeConversion;
import servicio.ConversorDeMonedas;
import servicio.GeneradorDeArchivos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        ConversorDeMonedas consulta = new ConversorDeMonedas();

        OpcionesDeConversion[] opciones = OpcionesDeConversion.values();
        ConversionDeMonedas[] conversiones = ConversionDeMonedas.values();
        OpcionesDeConversion selectedValue = (OpcionesDeConversion) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción de conversión",
                "Input",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if(selectedValue == OpcionesDeConversion.CONVERSOR_DE_MONEDAS){
            try {


                ConversionDeMonedas monedas = (ConversionDeMonedas) JOptionPane
                        .showInputDialog(null, "Selecciona la moneda a la que deseas convertir tu dinero: ", "Monedas"
                               JOptionPane.INFORMATION_MESSAGE, null,conversiones, conversiones[0]);

                List<String> paresDeDivisas = getParesDeDivisas(monedas);
                String base_code = paresDeDivisas.getFirst();
                String target_code = paresDeDivisas.getLast();


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

    private static List<String> getParesDeDivisas(ConversionDeMonedas moneda) {
        return switch (moneda) {
            case PESOS_A_DOLAR -> List.of("ARS", "USD");
            case PESOS_A_EURO -> List.of("ARS", "EUR");
            case PESOS_A_LIBRAS -> List.of("ARS", "GBP");
            case PESOS_A_YEN -> List.of("ARS", "JPY");
            case PESOS_A_WON_COREANO -> List.of("ARS", "KRW");
            case DOLAR_A_PESOS -> List.of("USD", "ARS");
            case EURO_A_PESOS -> List.of("EUR", "ARS");
            case LIBRAS_A_PESOS -> List.of("GBP", "ARS");
            case YEN_A_PESOS -> List.of("JPY", "ARS");
            case WON_COREANO_A_PESOS -> List.of("KRW", "ARS");
        };
    }
}
