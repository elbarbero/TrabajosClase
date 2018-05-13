/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package añobisiesto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class AñoBisiesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        int anno;
        System.out.println("AÑO: ");
        anno=Integer.parseInt(teclado.readLine());
        
        if(anno%4==0 &&anno%100!=0 || anno%400==0)//calculo completo para saber si es bisiesto o no
        {
            System.out.println("ES BISIESTO");
        }
        else
        {
            System.out.println("NO ES BISIESTO");
        }
    }
    
}
