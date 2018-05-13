/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio21.cadenas.tv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class CadenasTV {

    public String pedirCadena(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String canal="";
        System.out.print(mensaje);
        canal=teclado.readLine();
        try{
            /*Cuando comparamos datos String hay que poner "&&" en vez de "||"
            porque si ponemos "||" simpre va a estar dentro del while.*/
            while(canal.compareTo("")==0||canal.compareTo("1")!=0&&
                    canal.compareTo("2")!=0&&canal.compareTo("3")!=0&&
                    canal.compareTo("4")!=0&&canal.compareTo("5")!=0&&canal.compareToIgnoreCase("fin")!=0){
                System.out.print("Vuelve a introducir canal: ");
                canal=teclado.readLine();
            }
        }catch(IOException e){
        }
        return canal;
    }
}
