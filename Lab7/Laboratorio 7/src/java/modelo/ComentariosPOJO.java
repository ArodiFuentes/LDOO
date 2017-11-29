/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Arodi Fuentes 1837486
 */
public class ComentariosPOJO {
    private String nombre;
    private String comentario;


    public ComentariosPOJO(){    
    }
    
    public ComentariosPOJO(String nombre, String comentario){
        this.nombre = nombre;
        this.comentario = comentario;
    }
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getComentario() {
        return comentario;
    }


    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
