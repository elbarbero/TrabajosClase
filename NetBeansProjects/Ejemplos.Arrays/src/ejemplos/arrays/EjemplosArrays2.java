/*Ejemplos con Arrays 2 */
package ejemplos.arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class EjemplosArrays2 {

    public static void main(String[] args) {
        System.out.println("PRIMER ARRAY");

        String[] paises = new String[8];

        paises[0] = "España";
        paises[1] = "Francia";
        paises[2] = "Portugal";
        paises[3] = "Alemania";
        paises[4] = "Dinamarca";
        paises[5] = "Rusia";
        paises[6] = "Italia";
        paises[7] = "Argentina";

        for (int i = 0; i < paises.length; i++) {
            System.out.println("País " + (i + 1) + " " + paises[i]);
        }
        /*String[] paises2={"España","México","Luxemburgo","Guatemala","Noruega","Inglaterra"};
        Esta es otra forma de declarar un array.*/

        System.out.println("------------------------------------------------");
        System.out.println("SEGUNDO ARRAY");

        String[] nombres = new String[10];

        nombres[0] = "José";
        nombres[1] = "Mario";
        nombres[2] = "Ana";
        nombres[3] = "David";
        nombres[4] = "Nuria";
        nombres[5] = "María";
        nombres[6] = "Jorge";
        nombres[7] = "Lucía";
        nombres[8] = "Félix";
        nombres[9] = "Óscar";

        /*Este es el nuevo bucle for-each. Este nuevo bucle es más sencillo porque
        te despreocupas de que posición partes hasta que posición llegas.
        Dentro de los parentesis del bucle for tenemos que declarar una variable
        del mismo tipo que la matriz (array), en este caso es de tipo String.
        A continuación se pone el nombre que le queramos dar a esa variable
        (en la matriz anterior la hemos llamado "i"), en este caso la llamaremos
        "elemento" y el nombre de la matriz que en este caso se llama "nombres".*/
        for (String elemento : nombres) {
            /*Entre los parentesis del System se pone el nombre que le hayamos puesto a la variable.
            En nuestro caso la hemos llamado "elemento".*/
            System.out.println("Nombre: " + elemento);
        }

        System.out.println("------------------------------------------------");
        System.out.println("TERCER ARRAY");

        String[] ciudades = new String[5];

        for (int i = 0; i < 5; i++) {
            /*la clase JOptionPane te muestra una ventana donde introducir los datos.
            en este bucle for le estamos diciendo que hasta que los datos introducidos
            no sean 5( del 0 al 4), nos siga pidiendo datos.
            En cuanto esos datos sean 5, no lo mostrará con el bucle for siguiente.*/
            //ciudades[i] = JOptionPane.showInputDialog("Introduce ciudad " + (i + 1));
            ciudades[i] = JOptionPane.showInputDialog("Introduce ciudad " + (i + 1));
        }

        for (String prueba : ciudades) {
            /*Entre los parentesis del System se pone el nombre que le hayamos puesto a la variable.
            En nuestro caso la hemos llamado "prueba".*/
            System.out.println("Ciudad: " + prueba);
        }

        System.out.println("------------------------------------------------");
        System.out.println("CUARTO ARRAY");

        int[] matriz_aleatorios = new int[120];

        for (int i = 0; i < matriz_aleatorios.length; i++) {
            /*Dentro de este for hemos puesto que nos genere números aleatorios
            hasta que los números generados no sean 120.
            Math.round nos redondea los números.
            Math.random()*100 nos genera números aleatorios entre 0 y 100.
            Pueden salir números repetidos.*/
            matriz_aleatorios[i] = (int) Math.round(Math.random() * 100);
        }

        for (int numeros : matriz_aleatorios) {
            /*En este for nos muestra los numeros generados de forma aleatoria
            en el bucle anterior.Donde "numeros" es el nombre que
            le hemos puesto a la variable.*/
            System.out.print(numeros + " ");
        }
    }
}
