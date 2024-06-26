package modelos;

import interfaces.ITemperatura;

public class Temperatura implements ITemperatura {
    private int valorEnGrados;
    private String escala;

    public Temperatura() {
    }

    /**
     * Constructor para crear una instancia de Temperatura.
     * @param valorEnGrados El valor de la temperatura en grados.
     * @param escala La escala de la temperatura (Celsius, Kelvin, Fahrenheit).
     */
    public Temperatura(int valorEnGrados, String escala){
        this.valorEnGrados = valorEnGrados;
        this.escala = escala;
    }

    public int getValorEnGrados() {
        return valorEnGrados;
    }

    public void setValorEnGrados(int valorEnGrados) {
        this.valorEnGrados = valorEnGrados;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    /**
     * Convierte de Celsius a Kelvin.
     * @param celsius Temperatura en grados Celsius.
     * @return Temperatura en Kelvin.
     */
    @Override
    public double convertirCelsiusAKelvin(double celsius) {
        // La fórmula para convertir de Celsius a Kelvin es agregar 273.15 a la temperatura en Celsius.
        return celsius + 273.15;
    }

    /**
     * Convierte de Celsius a Fahrenheit.
     * @param celsius Temperatura en grados Celsius.
     * @return Temperatura en grados Fahrenheit.
     */
    @Override
    public double convertirCelsiusAFahrenheit(double celsius) {
        // La fórmula para convertir de Celsius a Fahrenheit es multiplicar por 9/5 y agregar 32.
        return (celsius * 9/5) + 32;
    }

    /**
     * Convierte de Kelvin a Celsius.
     * @param kelvin Temperatura en Kelvin.
     * @return Temperatura en grados Celsius.
     */
    @Override
    public double convertirKelvinACelsius(double kelvin) {
        // La fórmula para convertir de Kelvin a Celsius es restar 273.15 a la temperatura en Kelvin.
        return kelvin - 273.15;
    }

    /**
     * Convierte de Kelvin a Fahrenheit.
     * @param kelvin Temperatura en Kelvin.
     * @return Temperatura en grados Fahrenheit.
     */
    @Override
    public double convertirKelvinAFahrenheit(double kelvin) {
        // Primero convertimos de Kelvin a Celsius, luego de Celsius a Fahrenheit.
        return (kelvin - 273.15) * 9/5 + 32;
    }

    /**
     * Convierte de Fahrenheit a Celsius.
     * @param fahrenheit Temperatura en grados Fahrenheit.
     * @return Temperatura en grados Celsius.
     */
    @Override
    public double convertirFahrenheitACelsius(double fahrenheit) {
        // La fórmula para convertir de Fahrenheit a Celsius es restar 32 y luego multiplicar por 5/9.
        return (fahrenheit - 32) * 5/9;
    }

    /**
     * Convierte de Fahrenheit a Kelvin.
     * @param fahrenheit Temperatura en grados Fahrenheit.
     * @return Temperatura en Kelvin.
     */
    @Override
    public double convertirFahrenheitAKelvin(double fahrenheit) {
        // Primero convertimos de Fahrenheit a Celsius, luego de Celsius a Kelvin.
        return (fahrenheit - 32) * 5/9 + 273.15;
    }
}
