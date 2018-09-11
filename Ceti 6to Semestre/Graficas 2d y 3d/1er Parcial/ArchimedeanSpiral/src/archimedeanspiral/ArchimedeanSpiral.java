/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archimedeanspiral;
import java.awt.*;
import static java.lang.Math.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Minato
 */
public class ArchimedeanSpiral extends JPanel implements Runnable{
    
 
    
    private Thread thr;
    public Graphics2D g;
    public ArchimedeanSpiral() {
        
        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.white);
       
    }
    public void run(){
        double degrees = toRadians(0.1);
        double center = getWidth() / 2;
        double end = 360 * 10 * 50 * degrees;
        double a = 0;
        double b = 1;
        double c = 1;
        double theta = 0;
 
        while(theta<2){
        try{
            thr.sleep(1000);
 
        }
        catch(InterruptedException ex){
        
        }
        
        double r = a + b * pow(theta, 1 / c);
        double x = r * cos(theta);
        double y = r * sin(theta);
        
        theta ++;
            
        //JOptionPane.showMessageDialog(null, "Lo que se ve", "Titulo", JOptionPane.OK_OPTION);
        //super.updateUI();
        plot(g, (int) (center + x), (int) (center - y));
        super.repaint();
       //super.update(g);
       
        
        }
    
    }
    public void draLine(Graphics2D g, double theta){
        
        g.drawLine(0, 0, 200+(int)theta, 200+(int)theta);
        repaint();
    }
 
    void drawGrid(Graphics2D g) {
        g.setColor(new Color(0xEEEEEE));
        g.setStroke(new BasicStroke(2));
 
        double angle = toRadians(45);
 
        int w = getWidth();
        int center = w / 2;
        int margin = 10;
        int numRings = 8;
 
        int spacing = (w - 2 * margin) / (numRings * 2);
 
        for (int i = 0; i < numRings; i++) {
            int pos = margin + i * spacing;
            int size = w - (2 * margin + i * 2 * spacing);
            g.drawOval(pos, pos, size, size);
 
            double ia = i * angle;
            int x2 = center + (int) (cos(ia) * (w - 2 * margin) / 2);
            int y2 = center - (int) (sin(ia) * (w - 2 * margin) / 2);
 
            g.drawLine(center, center, x2, y2);
        }
    }
 
    void drawSpiral(Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.orange);
 
        double degrees = toRadians(0.1);
        double center = getWidth() / 2;
        double end = 360 * 10 * 50 * degrees;
        double a = 0;
        double b = 1;
        double c = 1;
 
        for (double theta = 0; theta < end; theta += degrees) {
            super.repaint();
            double r = a + b * pow(theta, 1 / c);
            double x = r * cos(theta);
            double y = r * sin(theta);
            plot(g, (int) (center + x), (int) (center - y));
            //super.repaint();
           
            
        }
    }
 
    void plot(Graphics2D g, int x, int y) {
        g.drawOval(x, y, 1, 1);
        this.show(true);
        //super.repaint();
        //super.update(g);
        
       //this.repaint();
        //double z=0;
        //while(z!=100000){z++;}
 
            
    }
 
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        thr = new Thread(this);
        thr.start();
 
        //drawGrid(g);
        
        //drawSpiral(g);
        
        }
    
    
    
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Archimedean Spiral");
            f.setResizable(false);
            f.add(new ArchimedeanSpiral(), BorderLayout.CENTER);
           
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
    
}
