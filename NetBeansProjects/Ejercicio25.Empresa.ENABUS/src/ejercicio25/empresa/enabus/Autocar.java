
package ejercicio25.empresa.enabus;

/**
 *
 * @author Mario Barbero
 */
public class Autocar {

    private String trayecto;
    private int plazasFum;
    private int plazasNoFum;
    private int plazasVendidasFum;
    private int plazasVendidasNoFum;
    private int tarifa;

    public Autocar(String trayecto, int plazasFum, int plazasNoFum, int tarifa) {
        /*Lo valores de estas variables se declaran en la clase Autocar, entre los parentesis.
        Esto es el constructor, aqui metemos los atributos del autocar.
        Lo llamaremos desde la clase Empresa.*/
        this.trayecto = trayecto;
        this.plazasFum = plazasFum;
        this.plazasNoFum = plazasNoFum;
        this.tarifa = tarifa;
    }

    public Autocar(int tarifa) {
        this.tarifa = tarifa;
    }

    public float getTarifa() {
        return tarifa;
    }

    public int getPlazasFum() {
        return plazasFum;
    }

    /*Aqui guardo las plazas totales que hay para no fumadores*/
    public int getPlazasNoFum() {
        return plazasNoFum;
    }

    public String getTrayecto() {
        return trayecto;
    }

    public int getplazasVendidasFum() {
        return plazasVendidasFum;
    }

    /*Aqui guardo las plazas totales que se han vendido para no fumadores*/
    public int getplazasVendidasNoFum() {
        return plazasVendidasNoFum;
    }

    /*Pongo set a estos dos siguientes métodos porque son los que van a variar a lo largo de la ejecución*/
    public void setPlazasVendidasFum(int plazasVendidasFum) {
        this.plazasVendidasFum = plazasVendidasFum;
    }

    public void setPlazasVendidasNoFum(int plazasVendidasNoFum) {
        this.plazasVendidasNoFum = plazasVendidasNoFum;
    }

    /*Aqui guardo las plazas totales del autobus*/
    public int totalPlazas() {
        int total;
        total = plazasFum + plazasNoFum;
        return total;
    }

    /*Aqui guardo las plazas libres que le quedan al autocar*/
    public int totalPlazasDisponibles() {
        int total;
        total = totalPlazas() - (plazasVendidasFum + plazasVendidasNoFum);
        return total;
    }

    /*Aqui guardo las plazas totales que se han vendido*/
    public int totalPlazasVendidas() {
        int total;
        total = plazasVendidasFum + plazasVendidasNoFum;
        return total;
    }

    public void SumarPlazasFum(int numBilletes) {
        plazasVendidasFum = plazasVendidasFum + numBilletes;
    }

    public void SumarPlazasNoFum(int numBilletes) {
        plazasVendidasNoFum = plazasVendidasNoFum + numBilletes;
    }
}
