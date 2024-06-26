import enums.ParesDeDivisas;
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

        Object selectedValue = JOptionPane.showInputDialog(
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

    public static List<ParesDeDivisas> getParesDeDivisas(ConversionDeMonedas moneda) {
        List<ParesDeDivisas> pares = new ArrayList<>();

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

    public static void ejecutarConversionDeMonedas(){
        try {
            String base_code = null;
            String target_code = null;

            ConversorDeMonedas consulta = new ConversorDeMonedas();
            ConversionDeMonedas[] conversiones = ConversionDeMonedas.values();

            ConversionDeMonedas monedas = (ConversionDeMonedas) JOptionPane
                    .showInputDialog(null,
                            "Selecciona la moneda a la que deseas convertir tu dinero: ",
                            "Monedas", JOptionPane.INFORMATION_MESSAGE,
                            null, conversiones, conversiones[0]);

            List<ParesDeDivisas> pares = getParesDeDivisas(monedas);

            for (ParesDeDivisas par : pares) {
                base_code = par.getFrom().toUpperCase();
                target_code = par.getTo().toUpperCase();
            }

            float conversion_rate = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Ingresa la cantidad de dinero que deseas convertir:", null));

            System.out.println("valores: "+base_code+", "+ target_code+", "+conversion_rate);

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
