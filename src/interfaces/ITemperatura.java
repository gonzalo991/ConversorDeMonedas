package interfaces;

import modelos.Temperatura;

public interface ITemperatura {
    double convertirCelsiusAKelvin(double celsius);
    double convertirCelsiusAFahrenheit(double celsius);

    double convertirKelvinACelsius(double kelvin);
    double convertirKelvinAFahrenheit(double kelvin);

    double convertirFahrenheitACelsius(double fahrenheit);
    double convertirFahrenheitAKelvin(double fahrenheit);
}