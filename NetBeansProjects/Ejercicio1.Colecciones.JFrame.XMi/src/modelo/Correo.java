/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Fecha;

/**
 *
 * @author Admin
 */
public class Correo {
    String fecha;
    String asunto, texto;
    Usuario remitente;
    Fecha f;

    public Correo(String fecha, String asunto, String texto, Usuario remitente) {
        this.fecha = fecha;
        this.asunto = asunto;
        this.texto = texto;
        this.remitente = remitente;//quien lo envia
    }

    public String getFecha() {
        return fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getRemitente() {
        return remitente;
    }
    
    
    
}
