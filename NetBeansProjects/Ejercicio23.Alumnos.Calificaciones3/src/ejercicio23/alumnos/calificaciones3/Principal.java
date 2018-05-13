/*23. Realiza un programa que introduzca los  nombres y la
 calificaciones de los alumnos de una clase hasta que el
 operador introduzca * como nombre.
 Finalizada la entrada de datos se mostrará
 en pantalla la siguiente información:
 */
package ejercicio23.alumnos.calificaciones3;

import java.io.IOException;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        /*Declaramos un objeto llamado misNotas*/
        Notas misNotas;
        misNotas=new Notas();
        /*Con el objeto misNotas accedemos a los métodos IntroducirNotas y
        VisualizarNotas pertenecientes a la clase Notas.*/
        misNotas.IntroducirNotas();
        misNotas.visualizarNotas();
    }
    
}
