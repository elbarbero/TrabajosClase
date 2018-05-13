/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.clase.meses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class EjercicioClaseMeses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        int num1;//este es el mes
        int num2;//este es el año
        System.out.print("INTRODUCE MES: ");
        num1=Integer.parseInt(teclado.readLine());//esta operacion no te guarda el numero
     
        
        if(num1<1|num1>12)//La raya "|" indica "o"
        {
            System.out.print("VUELVE A INTRODUCIR NUMERO: ");
            num1=Integer.parseInt(teclado.readLine());
        }
   
        System.out.print("AÑO: ");
        num2=Integer.parseInt(teclado.readLine());
        
        if (num1==1|num1==3|num1==5|num1==7|num1==8|num1==10|num1==12)
            {
                System.out.println("TIENE 31 DÍAS");
            }
        else
            {
                if(num2%4==0 &&num2%100!=0 || num2%400==0)//para indicar año bisiesto
                {
                    System.out.println("TIENE 29 DÍAS");
                }
                else
                {
                    if(num1==2)//Para indicar que febrero es el mes 2
                    {
                        System.out.println("TIENE 28 DÍAS");
                    }
                    else
                    {
                        if(num1==4|num1==6|num1==9|num1==11)
                        {
                            System.out.println("TIENE 30 DÍAS");
                        }
                    }
                }    
            }
    
    }     }

