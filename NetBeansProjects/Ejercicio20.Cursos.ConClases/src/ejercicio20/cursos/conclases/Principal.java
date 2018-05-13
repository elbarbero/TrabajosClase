/*Una academia oferta 3 cursos. (Curso1, Curso 2, Curso 3) ofertando
en cada uno de los cursos número diferente de plazas.
Se pide:
 Pedir el número de plazas que tiene cada curso.
 Proceso de matriculación de los alumnos, se les pedirá el curso
y la edad. Este proceso se realizará hasta que el operador pulse -1
como curso o bien no haya plazas disponibles en ningún curso.
 Finalizado el proceso de matriculación se emitirá el siguiente informe.
 */
package ejercicio20.cursos.conclases;

import java.io.IOException;

/**
 *
 * @author Mario Barbero
 */
public class Principal {

    public static void main(String[] args) throws IOException{
        Alumnos miAlumno=miAlumno=new Alumnos();
        miAlumno.pedirDatos();
        miAlumno.informe();
        
    }
    
}
