package enums;

import java.util.Arrays;

public enum OpcionesDeConversion {
    CONVERSOR_DE_MONEDAS("Conversor de monedas"),
    CONVERSOR_DE_TEMPERATURA("Conversor de temperatura");

    private String descripcion;

    private OpcionesDeConversion(String descripcion) {
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