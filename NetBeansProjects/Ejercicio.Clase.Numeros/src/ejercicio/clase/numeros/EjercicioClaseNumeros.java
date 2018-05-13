/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.clase.numeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class EjercicioClaseNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        int numero1;
        System.out.println("ESCRIBE NUMERO: ");
        numero1=Integer.parseInt(teclado.readLine());
    
         if(numero1>0)//para que diga que es positivo
        {
            System.out.println("SE POSITIVO "+numero1);
        }
        else
             if(numero1==0)//para que diga que es nulo o igual a cero
             {
                 System.out.println("ES NULO");
             }
             else//para que diga que es negativo                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
        {
            System.out.println("ES NEGATIVO ");
        }
    }
    
}
