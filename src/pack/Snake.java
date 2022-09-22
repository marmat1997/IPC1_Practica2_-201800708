
package pack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static pack.Panel.score;
public class Snake extends JPanel{
    Color colorSnake=Color.blue;
    Color colorcomida=Color.red;
    int tammax, tam,can;
    List<int []>snake=new ArrayList<>();
    int []comida=new int [2];
    String direccion = "de";
    String direccionproxima = "de";
    
    Thread hilo;
    Caminante camino;
    public Snake(int tammax, int can) {
        this.tammax = tammax;
//        this.tam = ;
        this.can = can;
        this.tam = tammax/can ;
        int []a= {can/2-1,can/2-1};
        int []b= {can/2,can/2-1};
        snake.add(a);
        snake.add(b);
        generarcomida();
        comida[0]=25;
        comida[1]=14;
        camino= new Caminante(this);
        hilo = new Thread(camino);
        hilo.start();
        //generarcomida();
    }
    @Override
 public void paint(Graphics pintor){
   super.paint(pintor);
   pintor.setColor(colorSnake);
//   for(int [] = 0;i<can ;i++){
       for(int i = 0;i<snake.size() ;i++){
          pintor.fillRect(snake.get(i)[0]*tam, snake.get(i)[1]*tam, tam-1,tam-1);
        }   
//   }
       pintor.setColor(colorcomida);
       pintor.fillRect(comida[0]*tam,comida[1]*tam, tam-1,tam-1);
 }
public void Avanzar () {
    igualar();
    int [] ultimo = snake.get(snake.size()-1);
    int agregarx = 0;
    int agregary = 0;
    switch (direccion) {
        case "de":agregarx=1; break;
        case "iz":agregarx=-1; break;
        case "ar":agregary=-1; break;
        case "ab":agregary=1; break;

    }
    int [] nuevo ={Math.floorMod(ultimo[0]+agregarx,can),Math.floorMod(ultimo[1]+agregary,can)} ;
    boolean aux=false;       
    for(int i = 0;i<snake.size() ;i++){
           if(nuevo[0]==snake.get(i)[0]&&nuevo[1]==snake.get(i)[1]){
           //exi=true;
           aux=true;
           //generarcomida();
           break;
          //pintor.fillRect(snake.get(i)[0]*tam, snake.get(i)[1]*tam, tam-1,tam-1);
        } }
    if(aux){
        JOptionPane.showMessageDialog(this, "has perdido");
        //break;
    }
    else{
      if(nuevo[0]==comida[0]&&nuevo[1]==comida[1]){
          snake.add(nuevo);
                           // Panel.score++;
           Panel.punto(score);
                     //System.out.println("comida");
         generarcomida();

//                   Panel.score++;
//           Panel.punto(score);
         
      }
      else{
              snake.add(nuevo);
              snake.remove(0);             
              //System.out.println("comida");
      }
    }
//    snake.add(nuevo);
//    snake.remove(0);
}
public void generarcomida(){
    //Panel.score++;
   // System.out.println(score);
    boolean exi = false;
int a =(int) (Math.random()*can);
int b =(int) (Math.random()*can);
       for(int i = 0;i<snake.size() ;i++){
           if(a==snake.get(i)[0]&&b==snake.get(i)[1]){
           exi=true;
           generarcomida();
           break;
          //pintor.fillRect(snake.get(i)[0]*tam, snake.get(i)[1]*tam, tam-1,tam-1);
        } }
       if(!exi){
       this.comida[0]=a;
       this.comida[1]=b;
//        Panel.score++;
//       System.out.println(score);
       }
}
//    class MyKeyAdapter extends KeyAdapter{
//        @Override
//        public void keyPressed(KeyEvent k){
//                switch(k.getKeyCode()){
//                case (KeyEvent.VK_S):
//                    cambiardireccion("ab");
//                    System.out.println("ab");
//                    
//                    break;
//                case (KeyEvent.VK_UP):
//                    if(direction != 'D' && !keyInput){
//                        direction = 'U';
//                        keyInput = true;
//                    }
//                    break;
//                case (KeyEvent.VK_LEFT):
//                    if(direction != 'R' && keyInput == false){
//                        direction = 'L';
//                        keyInput = true;
//                    }
//                    break;
//                case (KeyEvent.VK_RIGHT):
//                    if(direction != 'L' && keyInput == false){
//                        direction = 'R';
//                        keyInput = true;
//                    }
//                    break;
//                case (KeyEvent.VK_F2):
//                    if(!timer.isRunning()){
//                        startGame();
//                    }
//                    break;
//                case KeyEvent.VK_ESCAPE:
//					parentFrame.switchToLobbyPanel();
//					break;
//            }   
//        }
//        }
public void cambiardireccion(String dir){
    System.out.println(this.direccion);
    if((this.direccion.equals("de")||this.direccion.equals("iz"))&&((dir.equals("ar"))||(dir.equals("ab")))){
        this.direccionproxima=dir;
        System.out.println(dir);
}
    if((this.direccion.equals("ar")||this.direccion.equals("ab"))&&((dir.equals("iz"))||(dir.equals("de")))){
    this.direccionproxima=dir;
    System.out.println(dir);
}
}
public void igualar(){
    this.direccion=this.direccionproxima;
}
//public void punto(int score){
//    
//}
}
