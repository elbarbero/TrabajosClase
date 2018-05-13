/*25. La empresa ENABUS se dedica al transporte de viajeros por carretera.
Consta de una flota de varios autocares de 55 plazas cada uno que hacen
trayectos desde Barcelona a Tarragona y Zaragoza una vez al día.
Las primeras 35 plazas de cada autocar están reservadas a no fumadores.
Se pide el proceso de venta de billetes de las líneas hasta que no queden
plazas o bien hasta que el operador pulse * como nombre del comprador.
Por cada venta se pide el nombre del comprador, el destino, el número de
personas y el tipo de asiento. 
Si existe sitio , el programa calcula el importe ( 20 € por plaza) y lo visualiza.
Finalizado el proceso de venta obtener el siguiente informe
 */
package ejercicio25.empresa.enabus;

/**
 *
 * @author Mario Barbero
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa=new Empresa();
        miEmpresa.pedirVentaBilletes();
        miEmpresa.informe();
    }
    
}
