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
public class Categoria {
    private String nombre;
    private float tarifa;

    public Categoria(String nombre, float tarifa) {
        this.nombre = nombre;
        this.tarifa = tarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public float getTarifa() {
        return tarifa;
    }
    
            
    
}
