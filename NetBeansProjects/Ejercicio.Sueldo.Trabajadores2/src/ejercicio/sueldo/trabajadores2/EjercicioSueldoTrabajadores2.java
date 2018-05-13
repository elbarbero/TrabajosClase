/*22. Realiza un programa que introduzca el nombre
 y el sueldo de los trabajadores de una empresa
 hasta que el operador   * como nombre.
 Finalizada la entrada de datos se mostrará en
 pantalla la siguiente información:
 */
package ejercicio.sueldo.trabajadores2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioSueldoTrabajadores2 {

    public static void main(String[] args) throws IOException {
        int dato1;
        String dato2 = "";
        String nombre = "", copiaNombre = "";
        int contMil = 0, contDosMil = 0, contMasDosMil = 0;
        int conTotal = 0;
        float suma = 0, sueldo = 0, copiaSueldo = -1, media, porcentaje;
        EjercicioSueldoTrabajadores2 objeto = new EjercicioSueldoTrabajadores2();
        dato2 = objeto.pedirNombre("Nombre del trabajador: ");
        while (dato2.compareTo("*") != 0) {
            dato1 = objeto.pedirSueldo("Sueldo: ", 0);
            if (dato1 <= 1000) {
                contMil++;
            } else if (dato1 <= 2000) {
                contDosMil++;
            }
            if (dato1 > 2000) {
                contMasDosMil++;
            }
            if (dato1 > copiaSueldo) {//para saber quien es el que más cobra
                copiaNombre = dato2;
                copiaSueldo = dato1;//que me guarde sueldo en otra variable
            }
            conTotal++;
            suma = suma + dato1;
            dato2 = objeto.pedirNombre("Nombre del trabajador: ");
        }
        if (conTotal > 0) {
            media = (float) suma / conTotal;
            System.out.println("El sueldo medio es " + media + "€");
            porcentaje = ((float) contMil / conTotal) * 100;
            System.out.println("El porcentaje con menos de 1000€ es " + porcentaje + "%");
            porcentaje = ((float) contDosMil / conTotal) * 100;
            System.out.println("El porcentaje entre 1000€ y 2000€ es " + porcentaje + "%");
            porcentaje = ((float) contMasDosMil / conTotal) * 100;
            System.out.println("El porcentaje con más de 2000€ es " + porcentaje + "%");
            System.out.println("Sueldos menores de 1000€ --> \t" + contMil + "\t");
            System.out.println("Sueldos entre 1000€ y 2000€ --> \t" + contDosMil + "\t");//La "/t" es para hacer tabulaciones
            System.out.println("Sueldos mayores de 2000€ --> \t" + contMasDosMil + "\t");
            System.out.println("El trabajador con más sueldo es " + copiaNombre);//que me muestre el que mas a cobrado
        } else {
            System.out.println("ERROR. No hay datos");
        }
    }

    public String pedirNombre(String mensaje) throws IOException {
        //este método controla el nombre
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        System.out.print(mensaje);
        nombre = teclado.readLine();
        while (nombre.compareTo("") == 0) {
            System.out.println("ERROR");
            System.out.print(mensaje);
            nombre = teclado.readLine();
        }
        return nombre;
    }

    public int pedirSueldo(String mensaje, int limiteInferior) throws IOException {
        //este método controlo el SUELDO
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int sueldo = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
//el try siempre va acompañado de un catch. Para controlar una excepcion 
                System.out.print(mensaje);
                sueldo = Integer.parseInt(teclado.readLine());
                if (sueldo < limiteInferior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("NO ES NUMERO"+ex.getMessage());
            } catch (IOException ex) {
                System.out.println("ERROR I/O");
            }
        }
        return sueldo;
    }

}
