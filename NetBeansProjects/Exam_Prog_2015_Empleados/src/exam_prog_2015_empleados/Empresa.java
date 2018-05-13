package exam_prog_2015_empleados;

import Utilidades.Numeros;
import Utilidades.Caracteres;

/**
 * Clase Empresa
 *
 * @author Mario Barbero
 */
public class Empresa {

    Empleado[] empleados;
    Categoria[] categorias;

    public Empresa() {
        empleados = new Empleado[3];
        crearCategorias();
        inicializar();
    }

    /**
     * Contructor que recibe el numero de empleados
     *
     * @param nEmpleados guardamos el número de empleados
     */
    public Empresa(int nEmpleados) {
        /*nEmpleados depende del valor que le demos a la clase Empresa 
         desde la clase principal*/
 /*Si no ponemos nada los valores serán los que definamos en el 
         constructor el método de arriba en esta misma clase, que le hemos dado 2.*/
        empleados = new Empleado[nEmpleados];
        crearCategorias();
        inicializar();
    }

    /**
     * Método para crear las categorías
     */
    private void crearCategorias() {
        /*Este método solo se va a utilizar en esta clase*/
        categorias = new Categoria[4];
        /*Entre los parentesis ponemos en nombre de la categoría, el precio de las horas extra y el sueldo base, en el mismo orden
         en el que se han declarado en el constructor de la clase Categoria.
         No se pone el bucle for por cada categoría tiene valores diferentes*/
        categorias[0] = new Categoria("administrativo", 20, 200);
        categorias[1] = new Categoria("programador", 30, 220);
        categorias[2] = new Categoria("analista", 40, 250);
        categorias[3] = new Categoria("analista-programador", 50, 300);
    }

    /**
     * Este método crea los empleados
     */
    private void inicializar() {
        for (int numEmple = 0; numEmple < empleados.length; numEmple++) {
            /*La siguiente línea me crea a los empleados*/
 /*El bucle dice que mientras numEmple sea menor que la longitud total
             del array(los valores totales que guarda) sigue creando empleados.*/
            empleados[numEmple] = new Empleado();
        }
    }

    /*private int busquedaCategoria(int categoriaBuscar) {
        boolean encontrado = false;
        int pos = 0;
        while (!encontrado && pos < categorias.length) {
            if (empleados[pos].getCodCategoria() == (categoriaBuscar)) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (!encontrado) {
            System.out.println("NO SE ENCUENTRA LA CATEGORIA");
            pos = -1;
        }
        return pos;
    }*/
    /**
     * Método donde pedimos todos los datos del empleado
     */
    public void pedirDatos() {
        String nombre;
        int codigoCategoria;
        int totalHoras;
        Caracteres caracter = new Caracteres();
        Numeros numero = new Numeros();

        for (int nEmple = 0; nEmple < empleados.length; nEmple++) {
            //empleados[nEmple].setNombre(caracter.pedirString("NOMBRE: "));
            nombre = caracter.pedirString("NOMBRE: ");
            empleados[nEmple].setNombre(nombre);
            informacionCategorias();
            /*codigoCategoria = numero.pedirNumeroEntero("CATEGORÍA: ", 0, categorias.length - 1);
            empleados[nEmple].setCodCategoria(codigoCategoria);
            categ = busquedaCategoria(codigoCategoria);*/
            empleados[nEmple].setCodCategoria(numero.pedirNumeroEntero("CATEGORIA: ", 0, categorias.length - 1));
            /*La siguiente línea es igual que esto:
             codigoCategoria = numero.pedirNumeroEntero("CATEGORÍA: ", 0, categorias.length-1);
             empleados[nEmple].setCodCategoria(codigoCategoria);*/
            empleados[nEmple].setHorasExtra(numero.pedirNumeroEntero("HORAS TOTALES: ", 0));
        }
    }

    /**
     * Nos da información de cada categoría
     */
    public void informacionCategorias() {
        System.out.println("COD.CATEGORÍA" + "\t" + "CATEGORÍA" + "\t" + "\t" + "SUELDO BASE" + "\t" + "PRECIO HORA EXTRA");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println(i + "\t" + "\t" + categorias[i].getNomCategoria() + "\t" + "\t" + categorias[i].getSueldoBase() + "\t" + "\t" + categorias[i].getPrecioHora());
        }
    }

    public void informe() {
        System.out.println("CATEGORÍA" + "\t" + "NOMBRE" + "\t" + "\t" + "TOTAL HORAS" + "\t" + "SUELDO TOTAL");
        int pos;
        for (int nEmple = 0; nEmple < empleados.length; nEmple++) {
            pos=empleados[nEmple].getCodCategoria();
            System.out.println(categorias[empleados[nEmple].getCodCategoria()].getNomCategoria() + "\t" + "\t"
                    + empleados[nEmple].getNombre() + "\t" + "\t" + empleados[nEmple].getHorasExtra()
                    + "\t" + "\t" + empleados[nEmple].SueldoTotal(categorias[pos].sueldoBase, categorias[pos].precioHora));
            /*empleados[nEmple].SueldoTotal(categorias[empleados[nEmple].getCodCategoria()].sueldoBase*/
            //ES LO MISMO QUE LO DE ARRIBA
        }
    }
}
