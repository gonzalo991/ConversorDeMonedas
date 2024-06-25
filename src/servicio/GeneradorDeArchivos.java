package servicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Moneda;
import modelos.Temperatura;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivos {
    public void guardarConsultaMoneda(Moneda moneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escritura = new FileWriter(moneda.source()+".json");
        escritura.write(gson.toJson(moneda));
        escritura.close();
    }

    public void guardarConsultaTemperatura(Temperatura temperatura) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escritura = new FileWriter(temperatura.toString()+".json");
        escritura.write(gson.toJson(temperatura));
        escritura.close();
    }
}
