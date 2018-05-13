package ejercicio.diferencia.años;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class EjercicioDiferenciaAños {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        //Scanner entrada =new Scanner(System.in);//para poder poner caracteres
        int año1;
        int año2;
        int resultado;
        String opcion;
        System.out.print("INTRODUCE PRIMER AÑO: ");
        año1 = Integer.parseInt(teclado.readLine());
        System.out.print("INTRODUCE SEGUNDO AÑO: ");
        año2 = Integer.parseInt(teclado.readLine());
        if (año1 == año2) {
            System.out.println("LA DIFERENCIA ES DE 0 AÑOS");
            //System.out.print("¿QUIERES INTRODUCIR OTRO AÑO? 1/0: ");
            //opcion=entrada.next();//para poder poner si o no

        } else if (año1 < año2) {
            resultado = año2 - año1;
            System.out.println("LA DIFERENCIA ES DE " + resultado + " AÑOS");
        } else {
            resultado = año1 + año2;
            System.out.println("LA DIFERENCIA ES DE :" + resultado + " AÑOS");
        }
    }

}
