/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioclaseparimpar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class EjercicioClaseParImpar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException { 
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        int numero1;
        System.out.println("ESCRIBE NUMERO: ");
        numero1=Integer.parseInt(teclado.readLine());
        
        if(numero1%2==0)//para definir que un numero es par
        {
            System.out.println("ES PAR");
        }
        else
        {
            System.out.println("ES IMPAR");
        }
    }
}    

