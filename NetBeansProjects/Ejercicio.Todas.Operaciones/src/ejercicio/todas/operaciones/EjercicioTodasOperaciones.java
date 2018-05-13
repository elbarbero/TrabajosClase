package ejercicio.todas.operaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioTodasOperaciones {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float num1;
        float num2;
        double resultado;
        int op;
        //String dato;

        System.out.print("INTRODUCE PRIMER DATO: ");
        num1 = Integer.parseInt(teclado.readLine());
        System.out.print("INTRODUCE SEGUNDO DATO: ");
        num2 = Integer.parseInt(teclado.readLine());
        System.out.print("INSERTE DEL 1 AL 4: ");
        op = Integer.parseInt(teclado.readLine());
        //dato=teclado.readLine();//para introducir cualquier caracter

        switch (op) {
            case 1:
                resultado = num1 + num2;
                System.out.print("RESULTADO SUMA: " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.print("RESULTADO RESTA: " + resultado);
                break;
            case 3:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.print("RESULTADO DIVISIÓN: " + resultado);
                } else {
                    System.out.println("NO SE PUEDE DIVIDIR");
                }

                break;
            case 4:
                resultado = num1 * num2;
                System.out.print("RESULTADO MULTIPLICACIÓN: " + resultado);
                break;
            default:
                System.out.print("VALOR NO VALIDO");
                break;
        }

    }

}
