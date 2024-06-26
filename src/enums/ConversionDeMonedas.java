package enums;

import java.util.Arrays;

public enum ConversionDeMonedas {
    PESOS_A_DOLAR("De Pesos a Dólar"),
    PESOS_A_EURO("De Pesos a Euro"),
    PESOS_A_LIBRAS("De Pesos a Libras"),
    PESOS_A_YEN("De Pesos a Yen"),
    PESOS_A_WON_COREANO("De Pesos a Won Coreano"),
    DOLAR_A_PESOS("De Dólar a Pesos"),
    EURO_A_PESOS("De Euro a Pesos"),
    LIBRAS_A_PESOS("De Libras a Pesos"),
    YEN_A_PESOS("De Yen a Pesos"),
    WON_COREANO_A_PESOS("De Won Coreano a Pesos");

    private String descripcion;

    private ConversionDeMonedas(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
