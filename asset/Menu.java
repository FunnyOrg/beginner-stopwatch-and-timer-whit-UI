import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Menu extends JFrame {
  

    JFrame finestra = new JFrame("Menu"); 
    JButton t = new JButton("Timer");
    JButton c = new JButton("Cronometro");
    JLabel label = new JLabel();
    Font font = new Font("Verdana", Font.PLAIN, 15);

    public Menu() {
      Stopwatch st = new Stopwatch();
      TimerGUI tg = new TimerGUI();

      
     //label.setBounds(93, 60, 100, 30);
     //label.setFont(font);
     //label.setEnabled(true);
     //label.setVisible(true);
     //label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     //label.setOpaque(true);
  
        t.setBounds(40, 20, 200, 100);
        t.setFont(font);
        t.setFocusable(false);

        
        c.setBounds(40, 130, 200, 100);
        c.setFont(font);
        c.setFocusable(false);
        
        
        finestra.add(t);
        finestra.add(c);
        finestra.add(label);

       finestra.getContentPane().setBackground(Color.GRAY);
       finestra.setLayout(null);  
       finestra.pack();
       finestra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       finestra.setSize(300,300);
       finestra.setResizable(false);
       finestra.setVisible(true);
    }
}
