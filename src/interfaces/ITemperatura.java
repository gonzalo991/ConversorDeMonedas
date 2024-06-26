package interfaces;

import enums.ConversionesDeTemperatura;
import modelos.Temperatura;

public interface ITemperatura {
    void convertirCelsiusAKelvin(double celsius);
    void convertirCelsiusAFahrenheit(double celsius);

    void convertirKelvinACelsius(double kelvin);
    void convertirKelvinAFahrenheit(double kelvin);

    void convertirFahrenheitACelsius(double fahrenheit);
    void convertirFahrenheitAKelvin(double fahrenheit);
}