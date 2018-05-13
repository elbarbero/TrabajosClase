/*23.-.  Realiza un programa que introduzca los nombres y la calificaciones
de los alumnos de una clase hasta que el operador introduzca * como nombre.
Finalizada la entrada de datos se mostrará en pantalla la siguiente información:
 */
package ejemplos.get.set.conclases;

import java.io.IOException;

/**
 *
 * @author Mario
 */
public class Principal {

    public static void main(String[] args) throws IOException{
        Colegio miColegio=new Colegio();
        miColegio.pedirDatos();
        miColegio.informe();
    }
    
}
