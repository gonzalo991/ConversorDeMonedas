import excepciones.ErrorDeTipeoException;
import enums.ConversionDeMonedas;
import modelos.Moneda;
import enums.OpcionesDeConversion;
import servicio.ConversorDeMonedas;
import servicio.GeneradorDeArchivos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        OpcionesDeConversion[] opciones = OpcionesDeConversion.values();

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
            do{
                ejecutarConversionDeMonedas();
                int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?",
                        "Select an option", JOptionPane.YES_NO_CANCEL_OPTION);

                if (confirm != JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa terminado.");
                    break;
                }

            }while(true);

        } else if(selectedValue.equals("Conversor de temperatura")){
            System.out.println(selectedValue);
        }
    }

    public static List<String> getParesDeDivisas(ConversionDeMonedas moneda) {
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

    public static void ejecutarConversionDeMonedas(){
        try {
            ConversorDeMonedas consulta = new ConversorDeMonedas();
            ConversionDeMonedas[] conversiones = ConversionDeMonedas.values();

            ConversionDeMonedas monedas = (ConversionDeMonedas) JOptionPane
                    .showInputDialog(null,
                            "Selecciona la moneda a la que deseas convertir tu dinero: ",
                            "Monedas", JOptionPane.INFORMATION_MESSAGE,
                            null,conversiones, conversiones[0]);
            List<String> paresDeDivisas = getParesDeDivisas(monedas);
            String base_code = paresDeDivisas.getFirst();
            String target_code = paresDeDivisas.getLast();

            float conversion_rate = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Ingresa la cantidad de dinero que deseas convertir:","Input"));


            Moneda moneda = consulta.convertirMoneda(base_code, target_code, conversion_rate);
            double valorConvertido = moneda.conversion_result();

            String respuesta = String.format("La cantidad convertida es: %.2f %s", valorConvertido, target_code);

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
    }
}
