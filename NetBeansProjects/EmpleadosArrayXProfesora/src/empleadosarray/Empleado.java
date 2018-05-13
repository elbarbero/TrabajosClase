/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosarray;

/**
 *
 * @author ADMINMJ
 */
public class Empleado {

    private String nombre;
    private int horas;
    private int categoria;

    public Empleado() {
    }

    public Empleado(String n,
            int horas, int categoria) {
        nombre = n;
        this.horas = horas;
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public float calculoSueldoBruto(float precioHora) {
        float sbruto;
        if (horas <= 40) {
            sbruto = horas * precioHora;
        } else {
            sbruto = 40 * precioHora + (horas - 40) * precioHora * 1.8f;
        }
        return sbruto;
    }

    public float calculoDescuento(float sbruto) {
        float dto;
        if (sbruto < 300) {
            dto = sbruto * 0.05f;
        } else if (sbruto <= 600) {
            dto = sbruto * 0.1f;
        } else {
            dto = sbruto * 0.15f;
        }
        return dto;

    }
    public float calculoSalarioNeto(float sbruto, float dto)
    {
        float sneto;
        sneto= sbruto-dto;
        return sneto;
    }
}
