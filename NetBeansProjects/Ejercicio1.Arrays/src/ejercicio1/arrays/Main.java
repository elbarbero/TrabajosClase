/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.arrays;

/**
 *
 * @author 203pc19
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa = new Empresa(3);
        miEmpresa.pedirDatos();
        miEmpresa.ventasVendedores();
        miEmpresa.informe();
    }

}
