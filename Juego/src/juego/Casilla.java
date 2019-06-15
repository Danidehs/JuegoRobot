/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Daniel
 */
public class Casilla {
    
    
    private Robot R2D2;
  private Ficha F;
 private Posicion P;
  
  
  
  

    public Posicion getP() {
        return P;
    }

    public void setP(Posicion P) {
        this.P = P;
    }

    public Robot getR2D2() {
        return R2D2;
    }

    public void setR2D2(Robot R2D2) {
        this.R2D2 = R2D2;
    }
    
    public void setR2D2(int bolso,char nom, char sentido, Posicion pos, Boolean on){
    R2D2=new Robot(bolso,nom,sentido,pos,on);
    
    
    }

    public Ficha getF() {
        return F;
    }

    public void setF(Ficha F) {
        this.F = F;
    }

    public Casilla() {
        
    }

   
    
    
    
    
}
