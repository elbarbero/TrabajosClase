/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.programacion.pkg10.pkg2.pkg17;

import Utilidades.Numeros;
import Utilidades.Caracteres;

/**
 *
 * @author Mario
 */
public class Empresa {

    Empleados[] empleado;
    Provincias[] miProvincia;
    Comisiones[] miComision;

    public Empresa(int nEmple) {
        empleado = new Empleados[nEmple];
        crearEmpleados();
        miProvincia = new Provincias[7];
        crearProvincias();
        miComision = new Comisiones[5];
        crearComisiones();
    }

    private void crearEmpleados() {
        for (int nEmple = 0; nEmple < empleado.length; nEmple++) {
            empleado[nEmple] = new Empleados();
        }
    }

    private void crearComisiones() {
        miComision[0] = new Comisiones(10000, 0.05f);
        miComision[1] = new Comisiones(15000, 0.10f);
        miComision[2] = new Comisiones(20000, 0.15f);
        miComision[3] = new Comisiones(25000, 0.20f);
        miComision[4] = new Comisiones(Float.MAX_VALUE, 0.25f);
        /*El "Float.MAX_VALUE" indica que el máximo valor, es decir, en este caso, 
         que el límite va des el máximo de la comision anterior hasta el maximo valor que 
         le queramos meter (sin limite establecido)*/
    }

    private void crearProvincias() {
        miProvincia[0] = new Provincias("Burgos", 1000);
        miProvincia[1] = new Provincias("Soria", 900);
        miProvincia[2] = new Provincias("Segovia", 1000);
        miProvincia[3] = new Provincias("Avila", 800);
        miProvincia[4] = new Provincias("Valladolid", 1200);
        miProvincia[5] = new Provincias("Palencia", 850);
        miProvincia[6] = new Provincias("Leon", 1100);
    }

    private int busquedaComision(float ventas) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < miComision.length) {
            if (ventas <= miComision[pos].getImporteHasta()) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return pos;
    }

    public int buscarProvincias(String buscarProv) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < miProvincia.length) {
            if (miProvincia[pos].getNombre().compareToIgnoreCase(buscarProv) == 0) {
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

    public void pedirDatos() {
        Numeros numero = new Numeros();
        Caracteres caracter = new Caracteres();
        String provincia;
        int buscarProv;
        for (int nEmple = 0; nEmple < empleado.length; nEmple++) {
            // while (empleados[nEmple].getCodigoVendedor() != -1) {
            empleado[nEmple].setNombre(caracter.pedirString("Introduce nombre: "));
            empleado[nEmple].setVentas(numero.pedirNumeroEntero("Ventas: ", 0));
            provincia = caracter.pedirString("Porvincia: ");
            buscarProv = buscarProvincias(provincia);
            while (buscarProv == -1) {
                System.out.println("NO EXISTE ESA PROVINCIA");
                provincia = caracter.pedirString("Porvincia: ");
                buscarProv = buscarProvincias(provincia);
            }
            empleado[nEmple].setProvincia(provincia);
        }
    }

    public void informe() {
        int provincia;
        float ventas;
        int posPorcentaje;
        System.out.println("NOMBRE" + "\t" + "\t" + "PROVINCIA" + "\t" + "\t" + "IMPORTE VENTAS" + "\t" + "\t" + "SUELDO BASE" + "\t" + "\t" + "IMPORTE COMISIÓN" + "\t" + "\t" + "SUELDO TOTAL");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        for (int nEmple = 0; nEmple < empleado.length; nEmple++) {
            provincia = buscarProvincias(empleado[nEmple].getProvincia());
            ventas = empleado[nEmple].getVentas();
            posPorcentaje = busquedaComision(ventas);
            System.out.println(empleado[nEmple].getNombre() + "\t" + "\t" + miProvincia[provincia].getNombre() + "\t" + "\t" + "\t" + ventas + "\t" + "\t" + "\t" + miProvincia[provincia].getSueldoBase()
                    + "\t" + "\t" + empleado[nEmple].calculoPorcentaje(miComision[posPorcentaje].getPorcentaje()) + "\t" + "\t" + "\t"
                    + empleado[nEmple].calculoSueldo(miProvincia[provincia].getSueldoBase(), empleado[nEmple].calculoPorcentaje(miComision[posPorcentaje].getPorcentaje())));
        }
    }
}
