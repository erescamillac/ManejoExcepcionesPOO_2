/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.custom;

import java.util.Scanner;
import org.eec.util.StringUtils;
/**
 *
 * @author erick
 */

/*
------------------------------------------------------
**-- Tipos de datos primitivos en JAVA --**
Tipos de datos primitivos (JAVA) : [byte, short, int, long, float, double, boolean, char]
* java.lang.String

int,	(edad - años cumplidos) 
double, (peso - en Kg.)
char,	(sexo - ['H' / 'M'])
String	(nombre - [cadena de longitud mínima x])
------------------------------------------------------
*/
public class CustomInputReader {
    private Scanner scanner;
    
    public CustomInputReader(){
        scanner = new Scanner(System.in);
    }
    
    public double readDouble(String inputMsg, String errMsg){
        String inputAsStr, innerErr = "";
        double valorDouble = 0.0;
        boolean error = false;
        
        do{
            if(error){
                System.out.println("##################################################");
                System.out.println(String.format(errMsg, innerErr));
                System.out.println("##################################################");
            }
            
            System.out.println("---------------------------------------------------------------");
            System.out.println(inputMsg);
            
            inputAsStr = scanner.nextLine();
            inputAsStr = inputAsStr.trim();
        
            try{
                valorDouble = Double.parseDouble(inputAsStr);
                error = false;
                innerErr = "";
            }catch(NumberFormatException nfe){
                error = true;
                innerErr = String.format("La entrada [%s] NO representa un valor de punto flotante (por ej. 3.25, 0.12, 9.5).", inputAsStr);
            }catch(Exception e){
                error = true;
                innerErr = String.format("El valor [%s] NO es un número decimal válido (intente con valores como 3.14, 6.5, 9.5, etc.)", inputAsStr);
            }
            
        }while(error);
        
        return valorDouble;
    } //-- fin de método readDouble(inputMsg : String) : double
    
    public char readChar(String inputMsg, String errorMsg, boolean toUpperCase, String allowedChars){
        String inputAsStr, innerErr = "";
        StringBuilder errBuilder = new StringBuilder();
        char c = ' ';
        boolean error = false;
        
        do{
            
            if(error){
                System.out.println("############################################################");
                System.out.println(String.format(errorMsg, innerErr));
                System.out.println("############################################################");
            }
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println(inputMsg);
            
            inputAsStr = scanner.nextLine();
            inputAsStr = inputAsStr.trim();
            if( inputAsStr.isEmpty() ){
                // Cadena VACÍA ingresada
                error = true;
                innerErr = String.format("La entrada desde teclado [%s] es UNA CADENA VACÍA se debe INGRESAR 1 (un) Caracter (1 (una) letra).", inputAsStr);
            }else{
                error = false;
                innerErr = "";
                
                // uso de operador TERNARIO <var> = (expresion) ? TRUE-expr : FALSE-expr;
                c = toUpperCase ? inputAsStr.toUpperCase().charAt(0) :  inputAsStr.charAt(0);
                
                // -- VALIDAR si se trata de uno de los valores aceptados
                if(allowedChars.contains(Character.toString(c))){
                    // OK, se trata de uno de los caracteres Aceptados
                    error = false;
                    innerErr = "";
                }else{
                    // NO se trata de ninguno de los caracteres Aceptados
                    // primero "Flushear" el errBuilder
                    errBuilder.delete(0, errBuilder.length());
                    
                    errBuilder.append("El caracter ingresado [").append(c).append("]. NO");
                    errBuilder.append(" es alguno de las caracteres PERMITIDOS.");
                    errBuilder.append("Solo se permiten (").append(allowedChars.length()).append(")");
                    errBuilder.append(" caracteres : {");
                    
                    for(int i = 0; i < allowedChars.length(); i++){
                        errBuilder.append("'").append(allowedChars.charAt(i)).append("'");
                        if(i != allowedChars.length() - 1){
                            errBuilder.append(", ");
                        }
                    }
                    
                    errBuilder.append("}");
                    
                    innerErr = errBuilder.toString();
                    error = true;
                } //-- fin ELSE : (NO se trata de ninguno de los caracteres Aceptados)
            } //-- fin ELSE (cadena NO VACÍA) (al menos un caracter)
        }while(error);
        
        return c;
    } //-- fin de método readChar(inputMsg : String, errMsg : String, toUpperCase : boolean, allowedChars : String) : char
    
    public String readString(String inputMsg, String errorMsg, int minLength, boolean noDigitsAllowed){
        String str = "", innerErrorMsg = "";
        boolean error = false;
        
        do{
            if(error){
                System.out.println("############################################################");
                System.out.println(String.format(errorMsg, innerErrorMsg));
                System.out.println("############################################################");
            }
            
            try{
                System.out.println("---------------------------------------------------------");
                System.out.println(inputMsg);
                str = scanner.nextLine();
                str = str.trim();
                // System.out.println(String.format("Cadena leida desde el teclado <<%s>>", str));
                error = false;
                innerErrorMsg = "";
            }catch(Exception e){
                error = true;
                innerErrorMsg = "Ocurrió un ERROR inseperado al leer su entrada desde el Teclado.";
            }
            
            if(str.length() < minLength){
                error = true;
                innerErrorMsg = String.format("La cadena ingresada [%s] NO contiene AL MENOS (%d) caracteres.", str, minLength);
            }else{
                error = false;
                innerErrorMsg = "";
                
                if(noDigitsAllowed){
                // Validar que la cadena leida NO contenga dígitos
                    if (StringUtils.containsDigits(str)){
                        // ERROR : la cadena NO debe contener dígitos (NO debe contener ningún dígito)
                        innerErrorMsg = String.format("La cadena <<%s>> NO debe contener NINGUN dígito [0-9]. SOLO se deben ingresar LETRAS y Espacios.", str);
                        error = true;
                    }else{
                        error = false;
                        innerErrorMsg = "";
                    }
                } //-- fin IF (noDigitsAllowed)
                
            } //-- fin ELSE (la cadena ingresada TIENE la LONGITUD mínima solicitada)
            
        }while(error);
        
   
        return str;
    } //-- fin de método readString(inputMsg : String, errorMsg : String, minLength : int) : String
    
    public int readInt(String inputMsg, String errorMsg){
        int value = -1;
        boolean error = false;
        String inputAsStr = "inputStr";
        
        /*
        String str = "GeeksforGeeks.";
        // Concatenation of two strings
        String gfg1 = String.format("My Company name is %s", str);
        */
        
        do{
            if (error){
                System.out.println("######################################################");
                System.out.println(String.format(errorMsg, inputAsStr));
                System.out.println("######################################################");
            }
            System.out.println("----------------------------------------------------------");
            System.out.println(inputMsg);
            //-- (NOT suitable for our purposes) / (handle EMPTY strings) inputAsStr = scanner.next();
            // para el manejo de Cadenas VACÍAS (longitud 0); cuando el usuario teclea ENTER
            // sin ingresar ningún tipo de caracter NECESARIO invocar el método .nextLine() de
            // Scanner en lugar de .NEXT()
            
            inputAsStr = scanner.nextLine();
            try{
                value = Integer.parseInt(inputAsStr);
                error = false;
            }catch(NumberFormatException nfe){
                // System.err.println("El valor ingresado [" + inputAsStr + "] NO es un número Entero, favor de ingresar un número Entero. Inténtelo nuevamente.");
                error = true;
            }catch(Exception e){
                // System.err.println("El valor ingresado [" + inputAsStr + "] NO es un valor Entero. Inténtelo de nueva cuenta.");
                error = true;
            }
        }while(error);
          
        return value;
    } //-- FIN de método readInt(inputMsg : String)
    
}
