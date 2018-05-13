/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ADMINMJ
 */
public class Empresa {

    private Autocar autocar1;
    private Autocar autocar2;

    public Empresa() {

        autocar1 = new Autocar("tarragona", 30, 20, 10);
        autocar2 = new Autocar("zaragoza", 0, 50, 20);
    }

    public Autocar getAutocar1() {
        return autocar1;
    }

    public Autocar getAutocar2() {
        return autocar2;
    }

    public void ventaBilletes() {

        String nombre, destino, tipoPlaza;
        int nbilletes;
        float importe;
        nombre = pedirNombre();
        while ((!nombre.equalsIgnoreCase("*"))
                && (autocar1.totalDispo() > 0
                || autocar2.totalDispo() > 0)) {
            destino = pedirDestino();
            if (destino.equalsIgnoreCase(autocar1.getTrayecto())) {
                if (autocar1.totalDispo() > 0) {
                    tipoPlaza = pedirTipoPlaza();
                    nbilletes = pedirNumBilletes(tipoPlaza, autocar1);
                    autocar1.actualizarPlazas(nbilletes, tipoPlaza);
                    importe = nbilletes * autocar1.getTarifa();
                    System.out.println(" venta realizada. el importe es :" + importe);
                } else {
                    System.out.println("No hay plazas disponibles en ese trayecto");
                }
            } else {
                if (autocar2.totalDispo() > 0) {
                    tipoPlaza = pedirTipoPlaza();
                    nbilletes = pedirNumBilletes(tipoPlaza, autocar2);
                    autocar2.actualizarPlazas(nbilletes, tipoPlaza);
                    importe = nbilletes * autocar2.getTarifa();
                    System.out.println(" venta realizada. el importe es :" + importe);
                } else {
                    System.out.println("No hay plazas disponibles en ese trayecto");
                }
            }
            if ((autocar1.totalDispo() > 0 || autocar2.totalDispo() > 0)) {
                nombre = pedirNombre();
            }
        }

    }

    private String pedirNombre() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        try {
            System.out.println("Nombre o <*> para salir");
            nombre = teclado.readLine();
            while (nombre.compareTo("") == 0) {
                System.out.println("Nombre o <*> para salir");
                nombre = teclado.readLine();
            }
        } catch (IOException ex) {
        }
        return nombre;
    }

    private String pedirDestino() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String destino = "";
        try {
            System.out.println("destino");
            destino = teclado.readLine();
            while (destino.compareToIgnoreCase(autocar1.getTrayecto()) != 0
                    && destino.compareToIgnoreCase(autocar2.getTrayecto()) != 0) {
                System.out.println("destino inexistente");
                destino = teclado.readLine();
            }
        } catch (IOException ex) {
        }
        return destino;
    }

    private String pedirTipoPlaza() {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String tipo = "";
        try {
            System.out.println("Tipo Plaza <fumador o no fumador>");
            tipo = teclado.readLine();
            while (tipo.compareToIgnoreCase("fumador") != 0
                    && tipo.compareToIgnoreCase("no fumador") != 0) {
                System.out.println("Error fumador o no fumador");
                tipo = teclado.readLine();
            }
        } catch (IOException ex) {
        }
        return tipo;
    }

    private int pedirNumBilletes(String tipo, Autocar a) {
        int nbilletes = 0;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        boolean mal = true;
        while (mal) {
            try {
                System.out.println("Numero Billetes < 0 para anular>");
                nbilletes = Integer.parseInt(teclado.readLine());
                if (nbilletes >= 0 && nbilletes <= a.plazasDisponibles(tipo)) {
                    mal = false;
                } else {
                    System.out.println(" No hay tantas plazas disponibles. Hay"
                            + a.totalDisponiblesFumador() + " de fumador y "
                            + a.totalDisponiblesNoFumador() + " de no fumador"
                            + " en el trayecto " + a.getTrayecto());
                }

            } catch (NumberFormatException ex) {
                System.out.println(" debe de ser numérico");
            } catch (IOException ex) {
            }
        }
        return nbilletes;
    }

}
