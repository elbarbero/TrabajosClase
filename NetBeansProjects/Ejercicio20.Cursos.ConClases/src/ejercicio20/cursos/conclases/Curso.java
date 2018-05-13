package ejercicio20.cursos.conclases;

/**
 *
 * @Mario Barbero
 */
public class Curso {

    String nombre;
    int plazasOcupadas;
    int nPlazas;
//Esto es un constructor. El public siguiente.

    public Curso(String nombre, int nPlazas) {
        this.nombre = nombre;
        /*Aqui ponemos this porque donde hemos declarado las variables
         no las hemos dado un valor en ese momento.
         Por ejemplo: nPlazas=5, si se declara ahí,no hace falta poner el this.
         Si se declara en esta clase, no hace flata ponerlo etre los parentesis
         del método de la clase Alumnos*/
        this.nPlazas = nPlazas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public int getnPlazas() {
        return nPlazas;
    }

    /*Ponemos el accso public para que podemos acceder desde la clase Alumnos.
    Ponemos set porque las plazas las vamos a meter por teclado,
    por lo tanto, se van a modificar*/
    public void setnPlazas(int nPlazas) {
        this.nPlazas = nPlazas;
    }

    public int plazasDisponibles() {
        int total = 0;
        total = nPlazas - plazasOcupadas;
        return total;
    }

    public void SumarAlumnos() {
        plazasOcupadas++;
        /*plazasOcupadas es una propiedad de la clase y sumarAlumnos() es un método.
         Se diferencia en que los métodos llevaran parentesis al final
         y la propiedad no*/
    }

    /*public int sumarEdad(int edad) {
        int total=0 ;
        total = total + edad;
        return total;
    }*/
}
