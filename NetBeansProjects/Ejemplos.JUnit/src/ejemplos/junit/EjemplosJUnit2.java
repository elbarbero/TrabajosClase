package ejemplos.junit;

/**
 *
 * @author Mario
 */
public class EjemplosJUnit2 {

    private int ans;

    public EjemplosJUnit2() {
        ans = 0;
    }

    public int sumando(int a, int b) {//SUMA DOS VALORES Y LO GUARDA EN LA VARIABLE "ANS"
        ans = a + b;
        return ans;
    }

    public int restando(int a, int b) {//RESTA DOS VALORES Y LO GUARDA EN LA VARIABLE "ANS"
        ans = a - b;
        return ans;
    }

    public int añadir(int valor) {//NOS SUMA UN VALOR CUALQUIERA A LA VARIABLE "ANS" Y NOS LA DEVUELVE
        ans += valor;
        return ans;
    }

    public int quitar(int valor) {//NOS RESTA UN VALOR CUALQUIERA A LA VARIABLE "ANS" Y NOS LA DEVUELVE
        ans -= valor;
        return ans;
    }

    public int ans() {//POR SI QUEREMOS RECUPERAR SOLO EL VALOR DE LA VARIABLE "ANS"
        return ans;
    }

    public void borrado() {//TE BORRA EL VALOR QUE TENIA GUARDADO LA VARIABLE "ANS"
        ans = 0;
    }
}
