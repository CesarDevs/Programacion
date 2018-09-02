package practica1;
import javax.swing.*;
import java.awt.event.*;

public class Practica1 extends JFrame implements ActionListener{
    JTextField txtBox1, txtBox2;
    JLabel lbBox1, lbBox2;
    JButton btnSuma;

    public Practica1(){
        this.setBounds(10,10,400,400);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

        txtBox1 = new JTextField();
        txtBox1.setBounds (50,50,90,30);
        txtBox1.setName("txtBox1");
        txtBox1.setText("");
        this.add(txtBox1);

        txtBox2 = new JTextField();
        txtBox2.setBounds (200,50,90,30);
        txtBox2.setName("txtBox2");
        txtBox2.setText("");
        this.add(txtBox2);

        lbBox1 = new JLabel();
        lbBox1.setName("lbBox1");
        lbBox1.setText("Ingresa Numero 1");
        this.add(lbBox1);

        lbBox2 = new JLabel();
        lbBox2.setName("lbBox2");
        lbBox2.setText("Ingresa Numero 2");
        lbBox2.setBounds (200,50,90,30);
        this.add(lbBox2);

        btnSuma = new JButton();
        btnSuma.setName("btSuma");
        btnSuma.setText("+");
        btnSuma.setBounds(200,80,30,10);
        btnSuma.addActionListener( this);
        this.add(btnSuma);



    }


   
    public static void main (String[] args){
        Practica1 ob = new Practica1();
        ob.show();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Double result;
        result= Double.valueOf(txtBox1.getText()) + Double.valueOf(txtBox2.getText());
        JOptionPane.showMessageDialog(null, "La suma es:"+ result); 
    }
}