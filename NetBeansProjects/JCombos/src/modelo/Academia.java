/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Admin
 */
public class Academia {
    private Categoria[] categorias;

    public Academia(Categoria[] categorias) {
        this.categorias = categorias;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }
        
    public Categoria getUnaCategorias(int pos) {
        return categorias[pos];
    }
  
    //LLAMA AL METODO CATEGORIA PARA COMPARAR EL NOMBRE CON EL DE LA CLASE CAT
    public int busquedaCategoria(String nombreCategoria){ 
        int pos=0;
        boolean encontrado=false;
        while (!encontrado && pos<categorias.length){
            if(categorias[pos].getDenominacion().equalsIgnoreCase(nombreCategoria)){ 
                encontrado=true;
            }else{
                pos++;
            }
        }
        if(!encontrado){
            pos = -1;
        }
        return pos;
    }
    
    //LLAMA AL METODO CATERGORIA PARA HACER LA BUSQUEDA CURSO DESDE CAT
    public int busquedaCurso(String nombreCurso){ 
        int pos=0;
        boolean encontrado=false;
        while (!encontrado && pos<categorias.length){
            if(categorias[pos].busquedaCursoCAT(nombreCurso)!=-1){ //MIENTRAS NO LO ENCUENTRE (-1) PASA A OTRA CATEGORIA 
                encontrado=true;
            }else{
                pos++;
            }
        }
        if(!encontrado){
            pos = -1;
        }
        return pos;
    }
    
}
