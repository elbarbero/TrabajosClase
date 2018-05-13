/*Escribe un programa que permita calcular el área
de distintas figuras geométricas, a elección del usuario.
Primero, el usuario debe ver un menú de opciones para
elegir la figura geométrica cuya área desea calcular.
Una vez que el usuario elige su figura, el programa
debe solicitar los datos necesarios para calcular
el área de la figura elegida y mostrar el resultado correspondiente.
 */
package ejercicio.figuras.geometricas2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EjercicioFigurasGeometricas2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        byte figuras;
        double a, b, resultado = 0;
        System.out.print("Introduce figura(del 1 al 4): ");
        figuras = Byte.parseByte(teclado.readLine());
        while (figuras < 1 || figuras > 4) {
            System.out.print("Vuelve a introducir(del 1 al 4): ");
            figuras = Byte.parseByte(teclado.readLine());
        }
        switch (figuras) {
            case 1:
                System.out.print("Introduce base: ");
                a = Float.parseFloat(teclado.readLine());
                System.out.print("Introduce altura: ");
                b = Float.parseFloat(teclado.readLine());
                resultado = (a * b) / 2;
                System.out.println("El áerea del triángulo es " + resultado);
                break;
            case 2:
                System.out.print("Introduce base: ");
                a = Float.parseFloat(teclado.readLine());
                System.out.print("Introduce altura: ");
                b = Float.parseFloat(teclado.readLine());
                resultado = a * b;
                System.out.println("El áerea del rectangulo es " + resultado);
                break;
            case 3:
                System.out.print("Introduce lado: ");
                a = Float.parseFloat(teclado.readLine());
                resultado = a * a;
                System.out.println("El área del cuadrado es " + resultado);
                break;
            case 4:
                double pi = 3.1416;
                System.out.print("Introduce radio: ");
                a = Float.parseFloat(teclado.readLine());
                resultado = pi * (a * a);
                System.out.println("El área del circulo es " + resultado);
                break;
        }
    }

}
