/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class Caracteres {
/**
 * Te introduce cualquier dato de tipo String
 * @param mensaje Es el texto que queramos poner entre los parentesis
 * @return te devuelve un dato de tipo String
 */
    public String pedirString(String mensaje) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String dato = "";
        try {
            System.out.print(mensaje + " ");
            dato = teclado.readLine();
             /*El trim controla los espacios en blanco contandololos como que no se ha introducido nada*/
            while (dato.trim().equals("")) { //.trim() ELIMINA LOS ESPACIOS EN BLANCO 
                System.out.println("DEBES INTRODUCIR ALGO");
                System.out.print(mensaje + " ");
                dato = teclado.readLine();
            }
        } catch (IOException ex) {
        }
        return dato;
    }
}
