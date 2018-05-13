/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 203pc19
 */
public class Empresa {

    ArrayList<Cliente> clientes;
    ArrayList<Sala> salas;

    public Empresa() {
        clientes = new ArrayList<>();
        salas = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getUnCliente(int pos) {
        return clientes.get(pos);
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public Sala getUnaSala(int pos) {
        return salas.get(pos);
    }

    public void anadirUnCliente(Cliente c) {
        clientes.add(c);
    }

    public void anadirUnaSala(Sala s) {
        salas.add(s);
    }
 /*Creamos este método para que no se metan en la base de datos
     dos cif iguales*/

    public boolean buscarCliente(String cif) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < clientes.size()) {
            if (clientes.get(pos).getCif().compareToIgnoreCase(cif) == 0) {
                //if(clientes.get(pos).getCif().equalsIgnoreCase(cif)==0){
                encontrado = true;
            } else {
                pos++;
            }
        }
        return encontrado;
    }
/*Creamos este método para que no se metan en la base de datos
     dos cif iguales pero esta vez nos devuelve un dato de tipo cliente.
    Es igual que el anterior*/
    public Cliente buscarCliente2(String cif) {
        int pos = 0;
        boolean encontrado = false;
        Cliente c = null;
        while (!encontrado && pos < clientes.size()) {
            if (clientes.get(pos).getCif().compareToIgnoreCase(cif) == 0) {
                //if(clientes.get(pos).getCif().equalsIgnoreCase(cif)==0){
                encontrado = true;
            } else {
                pos++;
            }
            if (encontrado) {
                c = clientes.get(pos);
            }
        }
        return c;
    }
}
