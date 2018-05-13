/*
16.- Dado un número decir si es primo o no
 */
package ejercico.numero.primo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicoNumeroPrimo {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero, primo, primo2, resto=1;
        double primo3;
        System.out.print("Introduce número: ");
        numero = Integer.parseInt(teclado.readLine());

        //primo=numero/numero;
        //primo2=numero/1;
        //primo3 = numero / 3;
        //resto = numero % 2;
        while(resto!=0){
            primo=numero/2;
            resto=numero%2;
            primo=numero/primo;
        
        if (resto != 0 && primo != 1) {
            System.out.println("El número " + numero + " no es primo");
        } else {
            System.out.println("Es primo");
        }
    }
    }
}
