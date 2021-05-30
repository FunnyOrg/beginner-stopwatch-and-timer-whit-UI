

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
 
 JFrame window = new JFrame("Cronometro");
 JButton start = new JButton("Start!");
 JButton end = new JButton("Reset!");
 JLabel label = new JLabel();
 Font font = new Font("Verdana", Font.PLAIN, 15);

 int TempoPassato = 0;
 int Secondi     = 0;
 int Minuti     = 0;
 int Ore      = 0;
 boolean started = false;
 String stringa_secondi = String.format("%02d", Secondi);
 String stringa_minuti  = String.format("%02d", Minuti);
 String stringa_ora     = String.format("%02d", Ore);
 
 Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
   TempoPassato=TempoPassato+1000;
   Ore = (TempoPassato/3600000);
   Minuti = (TempoPassato/60000) % 60;
   Secondi = (TempoPassato/1000) % 60;

   stringa_secondi = String.format("%02d", Secondi);
   stringa_minuti  = String.format("%02d", Minuti);
   stringa_ora    = String.format("%02d", Ore);
   label.setText("  "+stringa_ora + ":" +stringa_minuti + ":" + stringa_secondi);
   
  }
  
 });

 
 
 Stopwatch(){
  
      label = new JLabel("  "+stringa_ora + ":" +stringa_minuti + ":" + stringa_secondi);
      label.setBounds(93, 60, 100, 30);
      label.setFont(new Font("Verdana", Font.PLAIN, 15));
      label.setEnabled(true);
      label.setVisible(true);
      label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      label.setOpaque(true);
  
        start.setBounds(35, 150, 100, 30);
        start.setFont(font);
        start.setFocusable(false);
        start.addActionListener(this);
        
        end.setBounds(150, 150, 100, 30);
        end.setFont(font);
        end.setFocusable(false);
        end.addActionListener(this);
        
        window.add(start);
        window.add(end);
        window.add(label);

        window.getContentPane().setBackground(Color.GRAY);
        window.setLayout(null);  
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(300,300);
        window.setResizable(false);
        window.setVisible(true);

 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==start) {
   
   if(started==false) {
    started=true;
    start.setText("Stop!");
    start();
   }
   else {
    started=false;
    start.setText("Start!");
    stop();
   }
   
  }
  if(e.getSource()==end) {
   started=false;
   start.setText("Start!");
   reset();
  }
  
 }
 
 void start() {
  timer.start();
 }
 
 void stop() {
  timer.stop();
 }
 
 void reset() {
  timer.stop();
  TempoPassato=0;
  Secondi=0;
  Minuti=0;
  Ore=0;
  stringa_secondi= String.format("%02d", Secondi);
  stringa_minuti = String.format("%02d", Minuti);
  stringa_ora = String.format("%02d", Ore);       
  label.setText("  "+stringa_ora + ":" +stringa_minuti + ":" + stringa_secondi);
 }

}

