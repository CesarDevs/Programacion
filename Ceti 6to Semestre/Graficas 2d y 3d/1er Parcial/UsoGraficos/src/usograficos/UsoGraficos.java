/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usograficos;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Minato
 */
public class UsoGraficos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsoDeGraficos g = new UsoDeGraficos();
        DrawCanvas c = new DrawCanvas();
        g.add(c);
        
        //g.drawString("Demo de Graficos", 10, 50);
    }
    
    public static class UsoDeGraficos extends JFrame{
    
        public  UsoDeGraficos()
        {
            super("Uso de graficos");
            setSize(1000,1000);
            
            
            //c.paint(g);
            show();
        }
   
    
    }
        private static class DrawCanvas extends JPanel {
      // Override paintComponent to perform your own painting
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);     // paint parent's background
         setBackground(Color.BLACK);  // set background color for this JPanel
 
         // Your custom painting codes. For example,
         // Drawing primitive shapes
         g.setColor(Color.YELLOW);    // set the drawing color
         g.drawLine(30, 40, 100, 200);
         g.drawOval(150, 180, 10, 10);
         g.drawRect(200, 210, 20, 30);
         g.setColor(Color.RED);       // change the drawing color
         g.fillOval(300, 310, 30, 50);
         g.fillRect(400, 350, 60, 50);
         // Printing texts
         g.setColor(Color.WHITE);
         g.setFont(new Font("Monospaced", Font.PLAIN, 12));
         g.drawString("Testing custom drawing ...", 10, 20);
      }
   }
    
    
    }

