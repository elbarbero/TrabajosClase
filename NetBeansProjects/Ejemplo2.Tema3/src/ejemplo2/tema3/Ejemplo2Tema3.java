/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2.tema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class Ejemplo2Tema3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{//el throws IOException hace que el programa se pare si falta el algun dispositivo de entrada salida
        InputStreamReader flujo;
        flujo=new InputStreamReader(System.in);
        BufferedReader entrada;
        entrada=new BufferedReader(flujo);
        String dato;
        int numero1;
        float numero2;
        float resultado;
        System.out.print("INTRODUCE EL DIVIDENDO: ");
        dato=entrada.readLine();//para que guarde el num1 en "dato"
        numero1=Integer.parseInt(dato);//Te lo convierte a un numero
        System.out.print("INTRODUCE EL DIVISOR: ");
        numero2=Float.parseFloat(entrada.readLine());//No te guarda el numero
        //no te guarda el num2
        resultado=numero1/numero2;
        System.out.println(numero1 +"/"+numero2+"="+resultado);
        //el println te hace un salto de linea al ejecutar el programa
    }
    
}
