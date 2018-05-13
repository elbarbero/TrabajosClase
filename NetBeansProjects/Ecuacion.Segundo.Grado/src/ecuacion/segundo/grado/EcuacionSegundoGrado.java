/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuacion.segundo.grado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class EcuacionSegundoGrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String dato;
        double a;
        int b;
        int c;
        double raiz;
        int exponente = 2;
        double potencia;//el resultado de la potencia de b
        double x;
        double y;

        System.out.print("INTRODUCE a: ");
        a = Integer.parseInt(teclado.readLine());
        System.out.print("INTRODUCE b: ");
        dato = teclado.readLine();//para que me guarde el resultado de la potencia
        b = Integer.parseInt(dato);

        System.out.print("INTRODUCE c: ");
        c = Integer.parseInt(teclado.readLine());
        //System.out.println("RESULTADO DE LA POTENCIA: "+potencia);

        //System.out.println("RAIZ= "+raiz);
        //PARA EL RESULTADO NEGATIVO
        if (a == 0)//para ecuacion de primer grado
        {
            if (b != 0) {//significa distinto de cero
                x = c / b;
                System.out.println("RESULTADO DE LA ECUACION DE 1GRADO: " + x);
            } else {
                System.out.println(" no es una ecuacion");
            }

        } else {
            potencia = Math.pow(b, exponente);
            raiz = potencia - (4 * (a * c));
            if (raiz >= 0) {
                raiz = Math.sqrt(raiz);
                x = (-b + raiz) / (2 * a);//PARA EL RESULTADO POSITIVO
                y = (-b - raiz) / (2 * a);
                System.out.println("RESULTADO x DE LA ECUACIÓN= " + x);
                System.out.println("RESULTADO y DE LA ECUACIÓN= " + y);
            } else {
                System.out.println("No tiene solucion");
            }

        }

    }
}
