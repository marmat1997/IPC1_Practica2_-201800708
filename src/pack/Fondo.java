/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author marma
 */
public class Fondo extends JPanel {
 Color colorfondo=Color.gray;
 int tammax, tam,can;

    public Fondo(int tammax, int can) {
        this.tammax = tammax;
//        this.tam = ;
        this.can = can;
        this.tam = tammax/can ;
    }
 public void paint(Graphics pintor){
   super.paint(pintor);
   pintor.setColor(colorfondo);
   for(int i = 0;i<can ;i++){
       for(int j = 0;j<can ;j++){
          pintor.fillRect(i*tam, j*tam, tam-1,tam-1);
        }   
   }
       
 }
}
