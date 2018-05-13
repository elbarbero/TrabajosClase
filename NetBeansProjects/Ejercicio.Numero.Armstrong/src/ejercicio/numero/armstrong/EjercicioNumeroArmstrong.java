/*
6.Escribe un programa que pida un número entero positivo
y diga si es un número Armstrong o no.
Un número es Armstrong cuando la suma de cada uno
de los dígitos que lo componen elevado al número
de dígitos del número da como resultado el propio número.
 */
package ejercicio.numero.armstrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioNumeroArmstrong {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int num1, copia;
        double rea,reb,rec;
        int a, b, c;
        int ncifras = 0;//numero de cifras

        System.out.print("Intoduce número: ");
        num1 = Integer.parseInt(teclado.readLine());
               //esto te separa las tres cifras del numero
        a = num1 / 100;//para el 1 digito
        b = (num1 % 100) / 10;//el resto de la anterior division entre 10
        c = (num1 % 10) % 10;//resto de la segunda division que será el ultimo digito
        copia = num1;//una copia para no borrar el numero1. copiar antes de entrar en el while

        while(num1<0){
            System.out.println("vuelve a introducir número: ");
            num1=Integer.parseInt(teclado.readLine());
        }
        while (num1 > 0) {//mayor que cero
            //El número de dígitos coincidirá tantas veces como podamos dividir dicho número entre 10.
            num1 = num1 / 10;
            ncifras = ncifras + 1;//es un contador
        }//FIN WHILE
            rea=Math.pow(a,ncifras);
            reb=Math.pow(b,ncifras);
            rec=Math.pow(c,ncifras);
        if(copia==rea+reb+rec){
            System.out.println("Es un número Armstrong");
        }
        else{
            System.out.println("No es un número Armstrong");
        }
    }

}
