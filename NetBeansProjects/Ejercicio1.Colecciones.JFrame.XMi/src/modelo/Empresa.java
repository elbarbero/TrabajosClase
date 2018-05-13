/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Empresa {
    private ArrayList <Usuario> usuarios;

    public Empresa(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Empresa() {
        usuarios = new ArrayList<>(); // CREAMOS UN ELEMENTO USUARIOS PARA CREAR UNA COLECCION DE DATOS. SINO NOS SALDRÍA JNullPointerException
    }

    public ArrayList <Usuario> getUsuarios() {
        return usuarios;
    }
    
    public Usuario getUnUsuarios(int posicion) {
        return usuarios.get(posicion);
    }

    public boolean buscarUsuario (String login){
        int i = 0;
        boolean encontrado = false;
        while (!encontrado  && i < usuarios.size()) {
            if(login.equalsIgnoreCase(usuarios.get(i).getNombre())){
                encontrado= true;
            }else{
                i++;
            }
        }
        return encontrado;
    }
    
    public int buscarUsuario (String login, String password){
        int i=0;
        boolean encontrado = false;
        while (!encontrado  && i < usuarios.size()) {
            if(login.equalsIgnoreCase(usuarios.get(i).getNombre()) && password.equals(usuarios.get(i).getPassword())){
                encontrado= true;
            }else{
                i++;
            }
        }
        if(!encontrado){
            i=-1;
        }
        return i;
    }
    
    public boolean buscarEmail (String email){
        int i = 0;
        boolean encontrado = false;
        while (!encontrado  && i < usuarios.size()) {
            if(email.equalsIgnoreCase(usuarios.get(i).getEmail())){
                encontrado= true;
            }else{
                i++;
            }
        }
        return encontrado;
    }
}
