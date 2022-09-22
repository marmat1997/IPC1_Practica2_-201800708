
package pack;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Caminante implements Runnable{
  Snake panel; 
  boolean estado=true;
public Caminante(Snake panel){
    this.panel=panel;
}
    @Override
    public void run() {
//        panel.Avanzar();
//        panel.repaint();
        while(estado){
                    panel.Avanzar();
                    panel.repaint();
      try {
          Thread.sleep(150);
          //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      } catch (InterruptedException ex) {
          Logger.getLogger(Caminante.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    }
    public void parar(){
        this.estado=false;
    }
}
