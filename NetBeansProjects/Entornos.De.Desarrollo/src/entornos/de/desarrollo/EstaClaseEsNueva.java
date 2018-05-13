/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.de.desarrollo;

public class EstaClaseEsNueva {

    private int contraseña;//los datos de tipo private solo lo puede ver el programador


    public EstaClaseEsNueva()//eso es el constructor. para "c" de la principal
    {
        this.contraseña=13579;
    }

        /**
     * @return the contraseña
     */
    public int getContraseña() {
        return contraseña;
    }
       /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }
}
