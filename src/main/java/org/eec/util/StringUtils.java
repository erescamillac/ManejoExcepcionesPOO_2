/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.util;

/**
 *
 * @author erick
 */
public class StringUtils {
    
    // returns TRUE if the given [str] argument length
    // is greater than 0 and contains AT LEAST 1 digit
    
    public static boolean containsDigits(String str){
        boolean containsDig = false;
        if( !str.isEmpty() && !str.isBlank() ){
            for(int i = 0; i < str.length(); i++){
                if (Character.isDigit( str.charAt(i) )){
                    // digito ENCONTRADO en str
                    containsDig = true;
                    break;
                } //-- fin de IF que valida si el caracter 'actual' es un DÍGITO [Character.isDigit()]    
            } //-- fin FOR : recorrido caracter a caracter de la cadena [str]
        } //-- fin IF que valida que la cadena tenga al menos 1 (un) caracter y 
        // NO sea un cadena en BLANCO (que contenga por lo menos 1 caracter distinto
        // de los 'espacios en blanco').
        return containsDig;
    } //-- fin de método : containsDigits() : boolean
    
} //-- fin Clase [StringUtils]
