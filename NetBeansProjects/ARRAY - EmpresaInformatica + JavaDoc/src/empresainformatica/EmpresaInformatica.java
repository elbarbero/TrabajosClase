/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresainformatica;

/**
 *
 * @author Admin R30
 */
public class EmpresaInformatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa EsguevaCompany;
        EsguevaCompany = new Empresa(3);
        EsguevaCompany.pedirDatosEmpleados();
        EsguevaCompany.informeSalario();

    }

}
