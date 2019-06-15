/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import static juego.Juego.bot;

/**
 *
 * @author Daniel
 */
public class Robot {
    
    
    private int bolso;
    private char nombre;
    private char sentido;
    private Posicion pos;
    private Boolean on;
    public Robot() {
        bolso=0;
        nombre='A';
        sentido='N';
        Posicion p= new Posicion();
        pos=p;
      on= false;
        
    }
    
    public Robot(Robot a){
        
        bolso=a.getBolso();
        nombre= a.getNombre();
        sentido= a.getSentido();
        pos= a.getPos();
        on=a.getOn();
       

}
    public Robot(int y,int x) {
        bolso=0;
        nombre='A';
        sentido='N';
        Posicion p= new Posicion(y,x);
        pos=p;
     on= false;
        
    }

    public Robot(int bolso, char nombre, char sentido, Posicion pos, Boolean on) {
        this.bolso = bolso;
        this.nombre = nombre;
        this.sentido = sentido;
        this.pos = pos;
        this.on = on;
    }

    public int getBolso() {
        return bolso;
    }

    public void setBolso(int bolso) {
        this.bolso = bolso;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public char getSentido() {
        return sentido;
    }

    public void setSentido(char sentido) {
        this.sentido = sentido;
    }

    public Posicion getPos() {
        return pos;
    }
    
    public void setPos(int y, int x){
    pos.setX(x);
    pos.setY(y);
    }

    public void setPos(Posicion pos) {
        this.pos = pos;
    }
  
    public void GirarD(){
   switch(sentido){
       case 'N':
           sentido='E';
           break;
       case 'E':
           sentido='S';
           break;    
       case 'S':
           sentido='O';
           break;    
        case 'O':
           sentido='N';
           break;   
           
                
               }
   
   
    
    
    }
    
    
    public void GirarI(){
   switch(sentido){
       case 'N':
           sentido='O';
           break;
       case 'E':
           sentido='N';
           break;    
       case 'S':
           sentido='E';
           break;    
        case 'O':
           sentido='S';
           break;   
           
                
               }
    }
    
    //Usar despues de el metodo LLenar Mapa 
    // sin terminar
    public Casilla[][] iniciar(Casilla[][] mapa, int y , int x){
        
        
        setPos(y,x);
        
        
        mapa[y][x].setR2D2(bolso,nombre, sentido,pos,on);
    
    return mapa;
    }
    
    public Casilla[][] mover(Casilla[][] mapa,int pasos){
    
        for (int i = 0; i < pasos; i++) {
            mapa= mover(mapa);
        }
    
    return mapa;
    }
    
   public Casilla[][] recogerBeeper(Casilla[][] mapa){
        
       int x = pos.getX();
       int y= pos.getY();
       
       if(mapa[y][x].getF() instanceof Beeper){
       FVacia v = new FVacia();
       mapa[y][x].setF(v);
       bolso++;
           System.out.println("");
           System.out.println("Beeper recogido");
       }
       else
       System.out.println(" Error: Beeper no encontrado");
   
   return mapa;
   }
   
   
   public Casilla[][] dejarBeeper(Casilla[][] mapa){
        
       int x = pos.getX();
       int y= pos.getY();
       
       if(bolso<=0){
           System.out.println("");
           System.out.println("Error: No tienes beepers en tu bolso");
       
       }
       else if(mapa[y][x].getF() instanceof Beeper){
           System.out.println("");
           System.out.println("Error: ya hay un beeper aqui");
       }
       else{
           
           Beeper v = new Beeper();
       mapa[y][x].setF(v);
       bolso--;
           System.out.println("");
           System.out.println("Beeper colocado ");
       
       }
   
   return mapa;
   }
   
    public Casilla[][] mover(Casilla[][] mapa){
        
       
        int x = pos.getX();
       
        int y= pos.getY();
        switch(sentido){
            
            
        case 'N': 
           if(0>y-1){
               System.out.println("Error: Me puedo caer");
           }
           else if(mapa[y-1][x].getF() instanceof Pared){
               System.out.println(" Error: Hay una pared enfrente.");
           }
           else if(mapa[y-1][x].getF() instanceof Cybers){
               setOn(Boolean.FALSE);
               System.out.println("Error ARTURITO piso un Cyber y se Apagara.");
               this.setPos(y,x);
               mapa[y-1][x].setR2D2(bolso, nombre , sentido, pos , on);
               mapa[y][x].setR2D2(null);
           }else{
               
              this.setPos(y-1,x);
           mapa[y-1][x].setR2D2(bolso, nombre , sentido, pos , on);
          mapa[y][x].setR2D2(null);
           }
           break;
            
            
       case 'E':
           if(7<x+1){
               System.out.println("Error: Me puedo caer");
           }
           else if(mapa[y][x+1].getF() instanceof Pared){
               System.out.println(" Error: Hay una pared ");
           }
           else if(mapa[y][x+1].getF() instanceof Cybers){
               setOn(Boolean.FALSE);
               System.out.println("Error: ARTURITO piso un Cyber y se Apagara.");
               this.setPos(y,x);
           mapa[y][x+1].setR2D2(bolso, nombre , sentido, pos , on);
          mapa[y][x].setR2D2(null);
           }else{
               
              this.setPos(y,x+1);
           mapa[y][x+1].setR2D2(bolso, nombre , sentido, pos , on);
          mapa[y][x].setR2D2(null);
           }
           break;    
           
           
       case 'S':
            if(7<y+1){
               System.out.println("Error: Me puedo caer");
           }
           else if(mapa[y+1][x].getF() instanceof Pared){
               System.out.println(" Error: Hay una pared ");
           }
           else if(mapa[y+1][x].getF() instanceof Cybers){
               setOn(Boolean.FALSE);
               System.out.println("Error: ARTURITO piso un Cyber y se Apagara.");
               this.setPos(y,x);
               mapa[y+1][x].setR2D2(bolso, nombre , sentido, pos , on);
               mapa[y][x].setR2D2(null);
           }else{
               
              this.setPos(y+1,x);
           mapa[y+1][x].setR2D2(bolso, nombre , sentido, pos , on);
          mapa[y][x].setR2D2(null);
           }
           break; 
           
           
        case 'O':
            
            if(x-1<=-1){
               System.out.println("Error: Me puedo caer");
           }
           else if(mapa[y][x-1].getF() instanceof Pared){
               System.out.println(" Error: Hay una pared ");
           }
           else if(mapa[y][x-1].getF() instanceof Cybers){
               setOn(Boolean.FALSE);
               System.out.println("Error: ARTURITO piso un Cyber y se Apagara.");
               this.setPos(y,x);
           mapa[y][x-1].setR2D2(bolso, nombre , sentido, pos , on);
          mapa[y][x].setR2D2(null);
                
           }else{
               
              this.setPos(y,x-1);
           mapa[y][x-1].setR2D2(bolso, nombre , sentido, pos , on);
          mapa[y][x].setR2D2(null);
           }
           break;   
        
        
        
        }
    
    return mapa;
    }
    
}