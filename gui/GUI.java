import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI {

    public static void UI() {
        int counter = 0;
        JButton start = new JButton("Start!");
        JButton end = new JButton("Stop!");


        JFrame window = new JFrame("-");    
        JLabel label;
        JPanel p = new JPanel(); 
        Container nc = window.getContentPane();
        Font font = new Font("Verdana", Font.PLAIN, 14);

//label 
label = new JLabel("00:00:00");
// label.setAlignmentX(label.CENTER);
// label.setAlignmentY(label.CENTER);
  label.setBounds(110, 60, 70, 30);
  label.setFont(new Font("Verdana", Font.PLAIN, 14));
  label.setEnabled(true);
  label.setVisible(true);
  
  for(int i = 0; i <6; i++) {
    
        counter++;

    label.setText(" Ciao " + counter);

  }
  //p.setComponentOrientation(label.CENTER);
  p.add(label); 

  //Button
  start.setBounds(35, 150, 100, 30);
  end.setBounds(150, 150, 100, 30);
  start.setFont(font);
  end.setFont(font);

  //Container
  p.setBackground(Color.WHITE);
  p.setBounds(93, 60, 100, 30);
  nc.setBackground(Color.gray);
  nc.add(start);
  nc.add(end);
  nc.add(label);
  nc.add(p);

  //Dimension of Container 
  int height = nc.getHeight();
  int width = nc.getWidth();
  System.out.println("Height: "+ height + " width: " + width );

  //Frame settings 
  //window.getContentPane().setBackground(Color.GRAY);
  window.setLayout(null);
  window.pack();
  window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
  window.setSize(300, 300);
  window.setResizable(false);
  window.setVisible(true);


        
    }

  

}