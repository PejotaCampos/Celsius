/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pedro
 */
public class Conversor {
    
    private String textoResposta;
    
    public Conversor()
    {
        this.textoResposta = "";
    }
    
    public String converter(double temperatura, String selecionada)
    {
        if(selecionada.equals("celsiusToFahrenheit"))
            return this.textoResposta = "A temperatura "+temperatura+" Celcius é igual a "+this.converterCelciusToF(temperatura)+" Fahrenheit.";
        
        return this.textoResposta = "A temperatura "+temperatura+" Fahrenheit é igual a "+ this.converterFToCelsius(temperatura)+ " Celsius.";
        
    }
    
    private double converterCelciusToF(double temperatura)
    {
        return (temperatura*9/5)+32;
    }
    
    private double converterFToCelsius(double temperatura)
    {
        return ((temperatura - 32.0)*5)/9;
    }
    
}
