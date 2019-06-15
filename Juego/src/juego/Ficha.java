/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Daniel
 */
public abstract class Ficha {
    
   protected  char nombre;

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
    
    
    
    public Ficha(){
    
    
    nombre= ' ' ;
    
    
    }
    
    
    
}
