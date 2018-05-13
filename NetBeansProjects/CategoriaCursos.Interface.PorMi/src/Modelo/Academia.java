/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 203pc19
 */
public class Academia {

    private Categoria[] categorias;

    public Academia(Categoria[] categorias) {
        this.categorias = categorias;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }

    public Categoria getUnaCategoria(int pos) {//ME DEVUELDE UNA CATEGORIA EN CONCRETO
        return categorias[pos];
    }

    public int busquedaCurso(String nombreCurso) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < categorias.length) {
            if (categorias[pos].buscarCurso(nombreCurso) != -1) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (!encontrado) {
            pos = -1;
        }
        return pos;
    }

    public int buscarCategoria(String nombreCategoria) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < categorias.length) {
            if (categorias[pos].getDenominacion().equalsIgnoreCase(nombreCategoria)) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (!encontrado) {
            pos = -1;
        }
        return pos;
    }
}
