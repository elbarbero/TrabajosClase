
package ejemplo.estructuras.repetitivas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203pc19
 */
public class EjemploEstructurasRepetitivas {

    public static void main(String[] args) throws IOException{
        double numero;
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        System.out.print("Número positivo: ");
        numero=Double.parseDouble(teclado.readLine());
        while(numero<0){
            System.out.println("Error. Número negativo");
            System.out.print("Número positivo: ");
            numero=Integer.parseInt(teclado.readLine());
        }
        
    }
    
}
