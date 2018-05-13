package Utilidades;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ADMINMJ
 */
public class Numeros {
/**
 * Método para introducir numeros enteros sin limites
 * @param mensaje es el texto que queremos poner entre los parentesis
 * @return devuelve un valor numerico entero
 */
    public int pedirNumeroEntero(String mensaje) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                mal = false;

            } catch (NumberFormatException ex) {
                System.out.println("DEBE DE SER UN NÚMERO");
            } catch (IOException ex) {
            }
        }
        return numero;
    }

    /**
     * Método para introducir numeros enteros con limites
     * @param mensaje es el texto que queremos poner entre los parentesis
     * @param limiteinferior Nos marca el limite inferior permitido
     * @return devuelve un valor numerico entero
     */
     
   public int pedirNumeroEntero(String mensaje, int limiteinferior) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                if (numero < limiteinferior) {
                    System.out.println(" el valor debe de ser Mayor que " 
                            + limiteinferior);
                } else {
                    mal = false;
                }

            } catch (NumberFormatException ex) {
                System.out.println("DEBE DE SER UN NÚMERO");
            } catch (IOException ex) {
            }
        }
        return numero;
    }
   /**
    * Método para introducir numeros enteros con limites
    * @param mensaje es el texto que queremos poner entre los parentesis
    * @param limiteinferior Nos marca el limite inferior permitido
    * @param limiteSuperior Nos marca el limite superior permitido
    * @return devuelve un valor numerico entero
    */
    public int pedirNumeroEntero(String mensaje, int limiteinferior,int limiteSuperior) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(teclado.readLine());
                if (numero < limiteinferior || numero >limiteSuperior) {
                    System.out.println(" el valor debe estar comprendido entre " 
                            + limiteinferior+ " y "+limiteSuperior);
                } else {
                    mal = false;
                }

            } catch (NumberFormatException ex) {
                System.out.println("DEBE DE SER UN NÚMERO");
            } catch (IOException ex) {
            }
        }
        return numero;
    }

}
