package servicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Moneda;
import modelos.Temperatura;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase para generar archivos JSON a partir de consultas de moneda y temperatura.
 */
public class GeneradorDeArchivos {

    /**
     * Guarda la consulta de una moneda en un archivo JSON.
     *
     * @param moneda Objeto de tipo Moneda a guardar en JSON.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardarConsultaMoneda(Moneda moneda) throws IOException {
        // Configurar Gson para formatear el JSON de manera legible
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Crear FileWriter para escribir en el archivo con el nombre basado en el código base de la moneda
        FileWriter escritura = new FileWriter(moneda.base_code() + ".json");

        // Convertir el objeto Moneda a JSON y escribirlo en el archivo
        escritura.write(gson.toJson(moneda));

        // Cerrar FileWriter después de escribir
        escritura.close();
    }

    /**
     * Guarda la consulta de una temperatura en un archivo JSON.
     *
     * @param temperatura Objeto de tipo Temperatura a guardar en JSON.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardarConsultaTemperatura(Temperatura temperatura, String escalaFinal) throws IOException {
        // Configurar Gson para formatear el JSON de manera legible
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Crear FileWriter para escribir en el archivo con el nombre basado en la representación textual de la temperatura
        FileWriter escritura = new FileWriter(temperatura.getEscala() + escalaFinal.replaceAll(" ","")+ ".json");

        // Convertir el objeto Temperatura a JSON y escribirlo en el archivo
        escritura.write(gson.toJson(temperatura));

        // Cerrar FileWriter después de escribir
        escritura.close();
    }
}