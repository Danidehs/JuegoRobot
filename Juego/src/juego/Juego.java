/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Juego {
    
    
    
   
     

    public static Casilla MapaInicial[][]= new Casilla[8][8];
    public static Casilla MapaFinal[][]= new Casilla[8][8];
    public static Robot bot= new Robot();
    public Scanner teclado = new Scanner(System.in);
    
    
    
    
    
    //sin terminar
    public boolean Win(){
        
        Boolean checkB=true;
        Boolean checkR=true;
        for (int i = 0; i < this.MapaFinal.length; i++) {
            for (int j = 0; j < this.MapaFinal.length; j++) {
                
                if(checkB){
                if(MapaFinal[i][j].getF().getNombre()!=MapaInicial[i][j].getF().getNombre())
                checkB=false;
                    
                }
                
                if(MapaFinal[i][j].getR2D2()!=null){
                    
                    if(MapaFinal[i][j].getR2D2().getPos().getX()!=bot.getPos().getX()||MapaFinal[i][j].getR2D2().getPos().getY()!=bot.getPos().getY()){
                        
                    checkR=false;
                    }
                
                }
                
            }
        }
        
        
       
    if(checkR==false || checkB==false)
    { return false;}
    
    else{
    return true;}
    
    
    }
    
    
    
    public void LlenarMapa() throws FileNotFoundException{
    
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                FVacia a= new FVacia();
                 MapaInicial[i][j]= new Casilla();
                 
                 MapaInicial[i][j].setF(a);
                 MapaFinal[i][j]= new Casilla();
                 MapaFinal[i][j].setF(a);
            }
            
        }
    
        
        
    //Cambiar textfile path   
    String FileName="C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Juego\\src\\juego\\File.txt";
    File f=new File(FileName);
    Scanner sc = new Scanner(f);
    boolean check= true;
    Boolean check2=true;
    while (sc.hasNextLine()){  
        String line= sc.nextLine();
        if(line.startsWith("Final")){
        check=false;
        
        }
        
        if(line.startsWith("Cybers")){
            line=line.substring(7);
            
            Scanner l=new Scanner(line);
            int y=l.nextInt();
             int x=l.nextInt();
            
            if(x<=7 && x>=0 && 0<=y && y<=7){
                Cybers C= new Cybers();
                MapaInicial[y][x].setF(C);
                MapaFinal[y][x].setF(C);
            }
            
            
        }
            
           if(line.startsWith("Pared")){
               line=line.substring(6);
               
             Scanner l=new Scanner(line);
             
             int y=l.nextInt();
              int x=l.nextInt(); 
              
              if(x<=7 && x>=0 && 0<=y && y<= 7){
              
              Pared P= new Pared();
              MapaInicial[y][x].setF(P);
              MapaFinal[y][x].setF(P);
               
               
              }
           }
                if(line.startsWith("Beeper")){
                
                line=line.substring(7);
              
             Scanner l=new Scanner(line);
             Beeper B = new Beeper();
             int y=l.nextInt();
              int x=l.nextInt(); 
               if(x<=7 && x>=0 && 0<=y && y<= 7){
              if(check)
              MapaInicial[y][x].setF(B);
              if(!check){
             MapaFinal[y][x].setF(B);
              }
               
               }
                
                }
                
                if(line.startsWith("ARTURITO")){
                    
                    line=line.substring(9);
                   
             Scanner l=new Scanner(line);
             int y=l.nextInt();
              int x=l.nextInt();
               if(x<=7 && x>=0 && y>=0 && y<= 7){
              Robot R2D2= new Robot(y,x);
                 MapaFinal[y][x].setR2D2(R2D2);
                check2=false;
            }
        }
            
    }
    
    if(check2){
        Robot R2D2= new Robot(7,0);
    
        MapaFinal[7][0].setR2D2(R2D2);
    }
    sc.close();
    }
    
    
    public void mostrarMapa(){
        System.out.println(" Mostrando Mapa Inicial");
        
        for (int i = 0; i < MapaInicial.length; i++) {
            System.out.println("");
            for (int j = 0; j < MapaInicial.length; j++) {
                
               if(MapaInicial[i][j].getR2D2()==null)
                System.out.print("("+ MapaInicial[i][j].getF().getNombre()+ ")");
                else
                    System.out.print("("+MapaInicial[i][j].getR2D2().getNombre()+")");
            }
            
        }
        
        }
        
    public void mostrarFinal(){
    
    for (int i = 0; i < MapaFinal.length; i++) {
            System.out.println("");
            for (int j = 0; j < MapaFinal.length; j++) {
                if(MapaFinal[i][j].getR2D2()==null)
                System.out.print("("+ MapaFinal[i][j].getF().getNombre()+ ")");
                else
                    System.out.print("("+MapaFinal[i][j].getR2D2().getNombre()+")");   
            }
            
        }
        
        }
    
    public void Jugar(){
        int resp=-1;
        do{
        System.out.println("");
        this.mostrarMapa();
        System.out.println("");
        System.out.println("Info de Arturito");
        System.out.println("Beeper en el bolso:"+bot.getBolso()+" //Sentido: "+bot.getSentido()+" //Poscion (y,x): ("+bot.getPos().getY()+","+bot.getPos().getX()+") //Encendido: "+bot.getOn());
        System.out.println("");
        System.out.println("");
        System.out.println(" Elige una accion");
        System.out.println("");
        
        System.out.println(" 1) Moverte en sentido: "+ bot.getSentido());
        System.out.println(" 2) Giro anti-horario");
        System.out.println(" 3) Giro horario");
        System.out.println(" 4) Recoger Beeper");
        System.out.println(" 5) Dejar Beeper");
        System.out.println(" 6) Encender");
        System.out.println(" 7) Moverte X espacios");
        System.out.println(" 8) Mostrar MapaFinal");
            
        System.out.println(" 0) Apagar");
        
        System.out.println(" ");
        
        
     resp= teclado.nextInt();
    teclado.nextLine();
    
    switch(resp){
        case 6:
        if(!bot.getOn()){
        bot.setOn(Boolean.TRUE);
            System.out.println(" Robot encendido");
        
        }
        else
                System.out.println(" El robot ya esta encendido");
        
    break;
    
        case 1:
            if(!bot.getOn()){
            
                System.out.println("");
                System.out.println("Error: Robot apagado");
                System.out.println("");
            }
            else{
       MapaInicial= bot.mover(MapaInicial);}
            
        break;
        
        case 7:
            if(!bot.getOn()){
            
                System.out.println("");
                System.out.println("Error: Robot apagado");
                System.out.println("");
            }
            else{
            System.out.println(" Cuantos espacios deseas moverte?");
        resp= teclado.nextInt();
        teclado.nextLine();
        MapaInicial=bot.mover(MapaInicial, resp);
            }
            
            break;
        case 3:
            if(!bot.getOn()){
            
                System.out.println("");
                System.out.println("Error: Robot apagado");
                System.out.println("");
            }
            else{
            bot.GirarD();
            }
            
            break;
        case 2:
            if(!bot.getOn()){
            
                System.out.println("");
                System.out.println("Error: Robot apagado");
                System.out.println("");
            }
            else{
            bot.GirarI();
            }
            break;
            
        case 4:
            if(!bot.getOn()){
            
                System.out.println("");
                System.out.println("Error: Robot apagado");
                System.out.println("");
            }
            else{
            MapaInicial=bot.recogerBeeper(MapaInicial);
            }
            break;
            case 5:
                if(!bot.getOn()){
            
                System.out.println("");
                System.out.println("Error: Robot apagado");
                System.out.println("");
            }
            else{
            MapaInicial=bot.dejarBeeper(MapaInicial);
                }
            break;
                
            case 8:
                System.out.println("");
                System.out.println(" Mostrarndo MapaFinal ");
                System.out.println("------------------------------");
                this.mostrarFinal();
                System.out.println("");
                System.out.println("------------------------------");
                System.out.println("");
                break;
                
            case 0:
               
                
                bot.setOn(Boolean.FALSE);
                System.out.println("Robot apagado");
                System.out.println("");
                System.out.println("Desea comparar mundos?");
                System.out.println(" 0) si, comparar");
                System.out.println(" 1) no, seguir jugando");
                resp= teclado.nextInt();
             break;
    
    }
        }
        while(resp!= 0);
        if(Win()){
        
            System.out.println("");
            System.out.println("Felicidades Igualaste los mundos y haz Ganado!");
            System.out.println("");
        
        
        
        }
        else{
            System.out.println("");
            System.out.println("Fallaste, los mundos no son iguales");
            System.out.println("");
            System.out.println("");
        }
    }
   
    // SIN TERMINAR
    public void Menu() throws FileNotFoundException{
    int respuesta=-1;
        
        do{
        System.out.println(" Bienvenido a el juego de Arturito");
        System.out.println("Para empezar a jugar: 1");
        System.out.println("Ver las reglas de juego: 2");
        System.out.println("Salir del juego: 3");
    respuesta= teclado.nextInt();
    
    
    switch(respuesta){
    
        case 1:
            int y;
                    int x;
            this.LlenarMapa();
            this.mostrarMapa();
            do{
            System.out.println("");
            System.out.println("Para comenzar a jugar deberas escoger una casilla (y,x) donde caera el robot");
                System.out.println(" Nota: Y y X deben estar entre los valores 0 y 7");
                System.out.println("Coordenada Y =");
                y=teclado.nextInt();
                System.out.println("Coordenada x =");
                x=teclado.nextInt();
            if(y< -1 || y>8||x< -1 || x>8){
             
                 System.out.println("");
                 System.out.println("Error: una de las coordenadas este fuera de los limites");
                 System.out.println("");
             }
             else  if(MapaInicial[y][x].getF() instanceof Pared){
             
                 System.out.println("");
                 System.out.println("Error: En esa coordenada se encuentra una pared");
                 System.out.println("");
             }
            }
           
            
            
            while(( y< -1 || y>8||x< -1 || x>8 || MapaInicial[y][x].getF() instanceof Pared));
             MapaInicial=Juego.bot.iniciar(MapaInicial, y, x);
            Jugar();
       
        break;
        
        case 2:
            System.out.println("");
            System.out.println(" Reglas");
            System.out.println(" ");
            System.out.println(" Eres un robot que se le asigno la tarea de mover beepers");
            System.out.println(" Para ganar deberas colocar a los beepers y al robot en las casillas respectivas de acuerdo al MapaFinal,");
            System.out.println(" el MapaFinal te muestra en que casillas debes poner los beepers y al robot.");
            System.out.println(" Deberas elegir una posicion en el mapa para colocar tu robot");
            System.out.println(" No podras mover al robot mientras este apagado");
            System.out.println(" y al apagarlo, deberas confirmar si quieres terminar sus labores para verificar si ganaste");
            System.out.println("");
            System.out.println("");
         break;
        
        case 3:
            System.out.println("");
            System.out.println(" Hasta luego!");
            System.out.println("");
        break;
    
    
    
    }
    }
    while(respuesta!=3);
    }
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException  {
        
        
         
        // TODO code application logic here
        Juego j= new Juego();
        j.Menu();
    }
}
