/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosarray;

import Utilidades.Caracteres;
import Utilidades.Numeros;

/**
 *
 * @author ADMINMJ
 */
public class Empresa {

    Empleado[] empleados;
    Categoria[] categorias;

    public Empresa() {
        empleados = new Empleado[10];
        inicializar();
        crearCategorias();
    }

    public Empresa(int numeroEmpleados) {
        empleados = new Empleado[numeroEmpleados];
        inicializar();
        crearCategorias();
    }

    private void crearCategorias() {
        categorias = new Categoria[4];
        categorias[0] = new Categoria("10", 6);
        categorias[1] = new Categoria("20", 8);
        categorias[2] = new Categoria("30", 10);
        categorias[3] = new Categoria("40", 14);
    }

    private void inicializar() {
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            empleados[nemple] = new Empleado();
        }
    }

    public void pedirDatosEmpleados() {
        String nombre;
        int horas;
        int categoria;
        Caracteres caracteres = new Caracteres();
        Numeros numeros = new Numeros();
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            nombre = caracteres.pedirString("NOMBRE: ");
            horas = numeros.pedirNumeroEntero("HORAS: ", 0);
            informacion();
            categoria = numeros.pedirNumeroEntero("CATEGORIA", 0, categorias.length - 1);
            empleados[nemple].setNombre(nombre);
            empleados[nemple].setCategoria(categoria);
            empleados[nemple].setHoras(horas);

        }

    }

    private void informacion() {
        System.out.println("NUM CATEGORIA \t NOMBRE");
        for (int numCategorias = 0; numCategorias < categorias.length; numCategorias++) {
            System.out.println(numCategorias + "\t"
                    + categorias[numCategorias].getNombre());
        }
    }

    public void pedirDatosEmpleados2() {
        String nombre;
        int horas;
        int categoria;
        Caracteres caracteres = new Caracteres();
        Numeros numeros = new Numeros();
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            nombre = caracteres.pedirString("NOMBRE: ");
            horas = numeros.pedirNumeroEntero("HORAS: ", 0);
            categoria = numeros.pedirNumeroEntero("CATEGORIA", 10, 40);
            empleados[nemple] = new Empleado(nombre, horas, categoria);
        }
    }

    public void informe() {
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            System.out.println(empleados[nemple].getNombre()
                    .toUpperCase());
        }
    }

    /**
     * Método que buscar en el array categorias el valor que desea el usuario
     *
     * @param categoriaBuscar valor a buscar
     * @return posicion de la categoria o -1 en caso de no encontrados
     */
    private int busquedaCategoria(String categoriaBuscar) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < categorias.length) {
            if (categorias[pos].getNombre().equalsIgnoreCase(categoriaBuscar)) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (!encontrado) {
            pos = -1;
        }
        return pos;
    }

    public void pedirDatosEmpleadosConNombreCategoria() {
        String nombre;
        String nombreCategoria;
        int horas;
        int categoria;
        Caracteres caracteres = new Caracteres();
        Numeros numeros = new Numeros();
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            nombre = caracteres.pedirString("NOMBRE: ");
            horas = numeros.pedirNumeroEntero("HORAS: ", 0);

            nombreCategoria = caracteres.pedirString("NOMBRE CATEGORIA");
            categoria = busquedaCategoria(nombreCategoria);
            while (categoria == -1) {
                System.out.println("CATEGORIA INEXISTENTE");
                nombreCategoria = caracteres.pedirString("NOMBRE CATEGORIA");
                categoria = busquedaCategoria(nombreCategoria);
            }

            empleados[nemple].setNombre(nombre);
            empleados[nemple].setCategoria(categoria);
            empleados[nemple].setHoras(horas);

        }

    }

    public void informeConSueldo() {
        float sbruto;
        int posicionCategoria;
        float tarifa;
        float descuento;
        float sneto;
        float smedio;
        smedio = calcularSueldoMedio();
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            posicionCategoria = empleados[nemple].getCategoria();
            tarifa = categorias[posicionCategoria].getTarifa();
            sbruto = empleados[nemple].calculoSueldoBruto(tarifa);
            if (smedio < sbruto) {
                descuento = empleados[nemple].calculoDescuento(sbruto);
                sneto = empleados[nemple].calculoSalarioNeto(sbruto, descuento);
                System.out.print(empleados[nemple].getNombre());
                System.out.print("\t" + categorias[posicionCategoria].getNombre());
                System.out.print("\t" + sbruto);
                System.out.print("\t" + descuento);
                System.out.println("\t" + sneto);
            }
        }
    }

    private float calcularSueldoMedio() {
        float sbruto, smedio, suma;
        suma = 0;
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            sbruto = empleados[nemple].calculoSueldoBruto(
                    categorias[empleados[nemple].getCategoria()].getTarifa());
            suma = suma + sbruto;

        }
        smedio = suma / empleados.length;
        return smedio;
    }

}
