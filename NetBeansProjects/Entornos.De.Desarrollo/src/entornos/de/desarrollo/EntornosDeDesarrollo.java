/*Esto es otro tipo de comentario. Va escrito de este modo*/
package entornos.de.desarrollo;

import Utilidades.Utilidades;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EntornosDeDesarrollo {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int contraseña;
        int numero = 0;
        String dato4;
        EstaClaseEsNueva c;
        Utilidades objeto = new Utilidades();//clase importada a traves del .jar
        dato4 = objeto.pedirNombre("Introduce Nombre: ");//este método pertece a la clase Utilidades
        c = new EstaClaseEsNueva();
        contraseña = c.getContraseña();
        System.out.print("Introduce contraseña: ");
        numero = Integer.parseInt(teclado.readLine());
        while (numero != contraseña) {
            if (numero != contraseña) {
                System.out.println("CONTRASEÑA INCORRECTA");
            }
            System.out.print("Vuelve a introducir contraseña: ");
            numero = Integer.parseInt(teclado.readLine());
        }
        System.out.println("ACCESO CONCEDIDO");

    }

}
