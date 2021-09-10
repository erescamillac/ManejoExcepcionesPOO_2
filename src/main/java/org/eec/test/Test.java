/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.test;

import org.eec.io.AppInputsReader;
/**
 *
 * @author erick
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AppInputsReader reader = new AppInputsReader();
        
        reader.leerTodosDatosUsuario();
    } //-- fin de método main(args : String[])
    
} //-- fin de Clase [org.eec.test.Test]
