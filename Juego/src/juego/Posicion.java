/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Daniel
 */
public class Posicion {
    private int y;
    private int x;

    public Posicion() {
        y=0;
        x=0;
        
    }

    public Posicion(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    
    
}
