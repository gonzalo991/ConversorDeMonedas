package modelos;

import interfaces.ITemperatura;

public class Temperatura implements ITemperatura {
    private double valorEnGrados;
    private String escala;

    public Temperatura() {
    }

    /**
     * Constructor para crear una instancia de Temperatura.
     * @param valorEnGrados El valor de la temperatura en grados.
     * @param escala La escala de la temperatura (Celsius, Kelvin, Fahrenheit).
     */
    public Temperatura(double valorEnGrados, String escala){
        this.valorEnGrados = valorEnGrados;
        this.escala = escala;
    }

    public double getValorEnGrados() {
        return valorEnGrados;
    }

    public void setValorEnGrados(double valorEnGrados) {
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
    public void convertirCelsiusAKelvin(double celsius) {
        // La fórmula para convertir de Celsius a Kelvin es agregar 273.15 a la temperatura en Celsius.
        double resultado = celsius + 273.15;
        setValorEnGrados(resultado);
        setEscala("Kelvin");
    }

    /**
     * Convierte de Celsius a Fahrenheit.
     * @param celsius Temperatura en grados Celsius.
     * @return Temperatura en grados Fahrenheit.
     */
    @Override
    public void convertirCelsiusAFahrenheit(double celsius) {
        // La fórmula para convertir de Celsius a Fahrenheit es multiplicar por 9/5 y agregar 32.
        double resultado = (celsius * 9/5) + 32;
        setValorEnGrados(resultado);
        setEscala("Fahrenheit");
    }

    /**
     * Convierte de Kelvin a Celsius.
     * @param kelvin Temperatura en Kelvin.
     * @return Temperatura en grados Celsius.
     */
    @Override
    public void convertirKelvinACelsius(double kelvin) {
        // La fórmula para convertir de Kelvin a Celsius es restar 273.15 a la temperatura en Kelvin.
        double resultado = kelvin - 273.15;
        setValorEnGrados(resultado);
        setEscala("Celsius");
    }

    /**
     * Convierte de Kelvin a Fahrenheit.
     * @param kelvin Temperatura en Kelvin.
     * @return Temperatura en grados Fahrenheit.
     */
    @Override
    public void convertirKelvinAFahrenheit(double kelvin) {
        // Primero convertimos de Kelvin a Celsius, luego de Celsius a Fahrenheit.
        double resultado = (kelvin - 273.15) * 9/5 + 32;
        setValorEnGrados(resultado);
        setEscala("Fahrenheit");
    }

    /**
     * Convierte de Fahrenheit a Celsius.
     * @param fahrenheit Temperatura en grados Fahrenheit.
     * @return Temperatura en grados Celsius.
     */
    @Override
    public void convertirFahrenheitACelsius(double fahrenheit) {
        // La fórmula para convertir de Fahrenheit a Celsius es restar 32 y luego multiplicar por 5/9.
        double resultado = (fahrenheit - 32) * 5/9;
        setValorEnGrados(resultado);
        setEscala("Celsius");
    }

    /**
     * Convierte de Fahrenheit a Kelvin.
     * @param fahrenheit Temperatura en grados Fahrenheit.
     * @return Temperatura en Kelvin.
     */
    @Override
    public void convertirFahrenheitAKelvin(double fahrenheit) {
        // Primero convertimos de Fahrenheit a Celsius, luego de Celsius a Kelvin.
        double resultado = (fahrenheit - 32) * 5/9 + 273.15;
        setValorEnGrados(resultado);
        setEscala("Kelvin");
    }
}
