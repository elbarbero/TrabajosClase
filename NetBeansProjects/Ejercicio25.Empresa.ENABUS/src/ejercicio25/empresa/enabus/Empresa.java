package ejercicio25.empresa.enabus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Empresa {

    private Autocar autocar1;
    private Autocar autocar2;

    public Empresa() {
        /*Entre los parentesis se pone el trayecto, las plazas para fumadores,
         las plazas para no fumadores y la tarifa, en ese orden.
         Estos valores corresponden al método public Autocar de la clase Autocar.
         El orden de los datos tienen que coincidir con el orden en el hayamos
         declarado las variables en el método de clase Autocar*/
        autocar1 = new Autocar("Tarragona", 35, 20, 20);
        autocar2 = new Autocar("Zaragoza", 10, 40, 10);
    }

    public Autocar getAutocar1() {
        return autocar1;
    }

    public Autocar getAutocar2() {
        return autocar2;
    }

    /*Lo pongo private porque solo es necesario utilizarlo en esta clase*/
    private String pedirTrayecto() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String trayecto = "";
        try {
            System.out.print("Introduce trayecto: ");
            trayecto = teclado.readLine();
            while (trayecto.compareToIgnoreCase(autocar2.getTrayecto()) != 0 && trayecto.compareToIgnoreCase(autocar1.getTrayecto()) != 0) {
                System.out.println("ESE TRAYECTO NO EXISTE");
                System.out.print("Vuelve a introducir trayecto: ");
                trayecto = teclado.readLine();
            }
        } catch (IOException e) {
        }
        return trayecto;
    }

    private int pedirNumAsientos() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numBilletes = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introduce número de asientos: ");
                numBilletes = Integer.parseInt(teclado.readLine());
                if (numBilletes < 0) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (IOException e) {
            } catch (NumberFormatException e) {
                System.out.println("ERROR. NO ES UN NÚMERO" + e.getMessage());
            }
        }
        return numBilletes;
    }

    private String pedirNombre() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        try {
            System.out.print("Introduce nombre: ");
            nombre = teclado.readLine();
            while (nombre.compareTo("") == 0) {
                System.out.println("ERROR");
                System.out.print("Vuelve a introducir nombre: ");
                nombre = teclado.readLine();
            }
        } catch (IOException e) {
        }
        return nombre;
    }

    private String pedirTipoAsiento() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String TipoAsientos = "";
        try {
            System.out.print("¿Fumador o No Fumador?: ");
            TipoAsientos = teclado.readLine();
            while (TipoAsientos.compareToIgnoreCase("fumador") != 0 && TipoAsientos.compareToIgnoreCase("no fumador") != 0) {
                System.out.print("ERROR");
                System.out.print("¿Fumador o No Fumador?: ");
                TipoAsientos = teclado.readLine();
            }
        } catch (IOException e) {
        }
        return TipoAsientos;
    }

    private String trayectoTarragona() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String tipoAsiento = "";
        int numBilletes;
        if (autocar1.totalPlazasDisponibles() > 0) {
            tipoAsiento = pedirTipoAsiento();
            numBilletes = pedirNumAsientos();
            if (tipoAsiento.compareToIgnoreCase("fumador") == 0 && (autocar1.getplazasVendidasFum() + numBilletes) <= autocar1.getPlazasFum()) {
                autocar1.SumarPlazasFum(numBilletes);
                /*Entre los parentesis del método "SumarPlazas" se pone el nombre de la variable
                 correspondiente que hayamos declarado en misma clase. En este caso se llama "numBilletes".
                 Tenemos que poner una variable entre los parentesis porque en este mismo método pero en la clase Autocar
                 lo hemos declarado ahí.
                 El nombre de la variable que se coloca entre los parentesis de dicho método, de la clase Empresa,
                 no tiene por que coincidir con el nombre de la variable que se hemos puesto
                 en dicho método de la clase Autocar. Si coincide es casualidad.*/
                System.out.println("El coste total de la compra de billetes es " + (autocar1.getTarifa() * numBilletes) + " €");
            } else if (tipoAsiento.compareToIgnoreCase("fumador") == 0) {
                System.out.println("No hay tantas plazas para fumadores para Tarragona");
            }
            if (tipoAsiento.compareToIgnoreCase("no fumador") == 0 && (autocar1.getplazasVendidasNoFum() + numBilletes) <= autocar1.getPlazasNoFum()) {
                autocar1.SumarPlazasNoFum(numBilletes);
                System.out.println("El coste total de la compra de billetes es " + (autocar1.getTarifa() * numBilletes) + " €");
            } else if (tipoAsiento.compareToIgnoreCase("no fumador") == 0) {
                System.out.println("No hay tantas plazas para no fumadores para Tarragona");
            }
        } else {
            System.out.println("El autocar para Tarragona está completo");
        }
        return tipoAsiento;
    }

    private String trayectoZaragoza() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String tipoAsiento = "";
        int numBilletes;
        if (autocar2.totalPlazasDisponibles() > 0) {
            tipoAsiento = pedirTipoAsiento();
            numBilletes = pedirNumAsientos();
            if (tipoAsiento.compareToIgnoreCase("fumador") == 0 && (autocar2.getplazasVendidasFum() + numBilletes) <= autocar2.getPlazasFum()) {
                autocar2.SumarPlazasFum(numBilletes);
                System.out.println("El coste total de la compra de billetes es " + (autocar2.getTarifa() * numBilletes) + " €");
            } else if (tipoAsiento.compareToIgnoreCase("fumador") == 0) {
                System.out.println("No hay tantas plazas para fumadores para Zaragoza");
            }
            if (tipoAsiento.compareToIgnoreCase("no fumador") == 0 && (autocar2.getplazasVendidasNoFum() + numBilletes) <= autocar2.getPlazasNoFum()) {
                autocar2.SumarPlazasNoFum(numBilletes);
                System.out.println("El coste total de la compra de billetes es " + (autocar2.getTarifa() * numBilletes) + " €");
            } else if (tipoAsiento.compareToIgnoreCase("no fumador") == 0) {
                System.out.println("No hay tantas plazas para no fumadores para Zaragoza");
            }
        } else {
            System.out.println("El autocar para Zaragoza está completo");
        }
        return tipoAsiento;
    }

    public void pedirVentaBilletes() {
        String nombre, trayecto, destZaragoza, destTarragona;
        int numBilletes;
        nombre = pedirNombre();
        while (nombre.compareTo("*") != 0 && (autocar1.totalPlazasDisponibles() > 0 || autocar2.totalPlazasDisponibles() > 0)) {
            trayecto = pedirTrayecto();
            if (trayecto.compareToIgnoreCase(autocar1.getTrayecto()) == 0) {
                destTarragona = trayectoTarragona();
            } else if (trayecto.compareToIgnoreCase(autocar2.getTrayecto()) == 0) {
                destZaragoza = trayectoZaragoza();
            }
            /*numBilletes = pedirNumAsientos();
             tipoAsiento = pedirTipoAsiento();
             Estos datos ya los pido en los métodos de cada trayecto*/
            /*Pongo este if para que cuando se llenen ambos autobuses salte directamente al informe
             sin pedir el nombre*/
            if (autocar1.totalPlazasDisponibles() > 0 || autocar2.totalPlazasDisponibles() > 0) {
                nombre = pedirNombre();
            }
        }
    }

    /*En public Informe se pone lo queremos que muestre. Lo llamamos desde la clase Principal.*/
    public void informe() {
        float porcTarragona, porcZaragoza;
        int fum, noFum;
        if (autocar1.totalPlazasVendidas() > 0 || autocar2.totalPlazasVendidas() > 0) {
            porcTarragona = ((float) autocar1.getplazasVendidasFum() + autocar1.getplazasVendidasNoFum()) / autocar1.totalPlazas() * 100;
            porcZaragoza = ((float) autocar2.getplazasVendidasFum() + autocar2.getplazasVendidasNoFum()) / autocar2.totalPlazas() * 100;
            System.out.println("DESTINO" + "\t" + "\t" + "NO FUMADORES" + "\t" + "\t" + "FUMADORES" + "\t" + "\t" + "TOTAL" + "\t" + "\t" + "PORCENTAJE");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(autocar1.getTrayecto() + "\t" + "\t" + autocar1.getplazasVendidasNoFum()
                    + "\t" + "\t" + "\t" + autocar1.getplazasVendidasFum() + "\t" + "\t"
                    + autocar1.totalPlazasVendidas() + "\t" + "\t" + porcTarragona);
            System.out.println(autocar2.getTrayecto() + "\t" + "\t" + autocar2.getplazasVendidasNoFum()
                    + "\t" + "\t" + "\t" + autocar2.getplazasVendidasFum() + "\t" + "\t"
                    + autocar2.totalPlazasVendidas() + "\t" + "\t" + porcZaragoza);
            System.out.println("TOTAL" + "\t" + "\t" + "\t" + (autocar1.getplazasVendidasNoFum() + autocar2.getplazasVendidasNoFum())
                    + "\t" + "\t" + "\t" + (autocar1.getplazasVendidasFum() + autocar2.getplazasVendidasFum())
                    + "\t" + "\t" + (autocar1.totalPlazasVendidas() + autocar2.totalPlazasVendidas())
                    + "\t" + "\t" + ((float) porcTarragona + porcZaragoza) / 2);
            if (autocar1.totalPlazasVendidas() < autocar2.totalPlazasVendidas()) {
                System.out.println("La línea con más ocupación es " + autocar2.getTrayecto());
            } else {
                System.out.println("La línea con más ocupación es " + autocar1.getTrayecto());
            }
        } else {
            System.out.println("ERROR. NO SE HA INTRODUCIDO NINGÚN DATO.");
        }
    }
}
