/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.io;

import java.io.IOException;
import org.eec.custom.CustomInputReader;
/**
 *
 * @author erick
 */
public class AppInputsReader {
    
    private CustomInputReader inputReader;
    
    public AppInputsReader(){
        inputReader = new CustomInputReader();
    }
    /*
        String str = "GeeksforGeeks.";
        // Concatenation of two strings
        String gfg1 = String.format("My Company name is %s", str);
    */
    
    private int leerEdad(){
        String msgError = "";
        int edad = -1;
        boolean error = false;
        do{
            if(error){
                System.out.println("################################################################");
                System.out.println(msgError);
                System.out.println("################################################################");
            }
            
            edad = inputReader.readInt("Ingresa tu Edad (como Entero / años cumplidos):", "ERROR: La entrada [%s] NO representa un valor de Edad CORRECTO como valor ENTERO, por favor, inténtelo nuevamente.");
            
            if(edad < 0){
                error = true;
                msgError = String.format("NO se aceptan Edades NEGATIVAS [%d], inténtelo nuevamente.", edad);
            }else{
                error = false;
                msgError = "";
            }
        }while(error);
        
        return edad;
    }
    
    private String leerNombre(){
        String name;
        name = inputReader.readString("Ingresa tu nombre (longitud mínima de 3 caracteres): ", "Ha ocurrido un ERROR al leer su Nombre desde el teclado [%s]. Por favor, inténtelo nuevamente.", 3, true);
        return name;
    } //-- fin de método leerNombre() : String
    
    private char leerSexo(){
        char c = ' ';
        c = inputReader.readChar("Ingresa tu sexo ['H' / 'M'] (1 SOLO caracter : 'H' o 'M'): ", "ERROR: Ocurrió un error al momento de leer tu sexo [%s]. Por favor, inténtelo nuevamente.", true, "HM");
        return c;
    }
    
    private double leerPeso(){
        double peso = 0.0;
        // 4.- Ingresa tu peso en Kg (por ej. 60.5, 55.3, 65.250) (SOLO el valor numérico -puede incluir punto decimal o no-): 
        peso = inputReader.readDouble("Ingresa tu peso en Kg (por ej. 60.5, 55.3, 65.250) (SOLO el valor numérico -puede incluir punto decimal o no-): ", "Ocurrió un ERROR al leer tu peso [%s]. Por favor, inténtelo nuevamente.");
        return peso;
    }
    
    public void leerTodosDatosUsuario(){
        int edad;
        char sexo;
        double peso;
        String nombre;
        
        try {
            System.out.println("--Por favor ingrese los DATOS solicitados--");
            // 1.- Ingresa tu Nombre (logitud mínima 3 caract.): 
            nombre = leerNombre();
            
            // 2.- Ingresa tu sexo ['H' / 'M'] (1 SOLO caract. 'H' o 'M'): 
            sexo = leerSexo();
            
            // 3.- Ingresa tu edad (como Entero / años cumplidos)
            edad = leerEdad();
            
            // 4.- Ingresa tu peso en Kg (ej. 60.5) (SOLO el valor numérico -puede incluir punto decimal o no-): 
            peso = leerPeso();
            
            System.out.println("&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/");
            System.out.println("Los datos INGRESADOS fueron: ");
            
            System.out.println(String.format("Nombre: %s", nombre));
            System.out.println(String.format("Sexo : %s", sexo));
            
            System.out.println(String.format("Edad: %d años.", edad));
            System.out.println(String.format("Peso: %6.3f Kg.", peso));
            
            
            System.out.println("&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/&!#$%&/");
            
            System.out.println("¡Gracias por utilizar DataReader v1.0!");
            System.out.println("Hasta la próxima");
            System.out.println("Presione ENTER para salir de la Aplicación...");
            
            System.in.read();
            
            System.out.println("***Aplicación FINALIZADA***");
        } //-- fin de método leerTodosDatosUsuario() : void
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
} //-- fin de Clase [org.eec.io.AppInputsReader]
