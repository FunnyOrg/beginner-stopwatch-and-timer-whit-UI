

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;





public class TimerGUI {
	
    int counter = 3600000;
    int Secondi     = 0;
    int Minuti     = 0;
    int Ore      = 0;
    boolean startato = false;
    String stringa_secondi = String.format("%02d", Secondi);
    String stringa_minuti  = String.format("%02d", Minuti);
    String stringa_ora     = String.format("%02d", Ore);




    JTextArea area = new JTextArea();
	boolean started = false;
    JLabel label, timerLabel;
    JButton start = new JButton("Start!");
    JFrame window = new JFrame("Timer");
    JButton end = new JButton("end");
    //int counter = 30;
    Timer timer;
    Font font = new Font("Verdana", Font.PLAIN, 15);
    
    public TimerGUI() {
    	
    	timer = new Timer(1000, new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			counter--;
    			if(getCounter() == 0) {
    				fermo();
    			}
    			label.setText(" " + getCounter());
    		}
    		
    	});
    	//label
    	label = new JLabel("   Tempo rimasto: 0");
    	label.setBounds(50, 60, 180, 30);
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setEnabled(true);
        label.setVisible(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setOpaque(true);
        
        //button
        start.setBounds(35, 150, 100, 30);
        start.setFont(font);
        start.setFocusable(false);
       
         //Area di testo
        area.setBounds(50, 100, 180, 30);
        area.setText("  "+stringa_ora + ":" +stringa_minuti + ":" + stringa_secondi);
        area.setVisible(true);
        area.setFont(new Font("Verdana", Font.PLAIN, 15));
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        area.setOpaque(true);
        area.setEnabled(true);

        

        //start.setEnabled(true);
        
        
        start.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
                    
                    String input = area.getText();
                    System.out.println(input);
        		//if(e.getSource() == start) {
        			if(started == false) {
        				started = true;
        				start.setText("Stop!");
        				avvia();
        			} else {
        				started = false;
        				start.setText("Start!");
        				fermo();
        			}
        	//	}
        	
        		//start.setEnabled(false);
        		//end.setEnabled(true);
        		
        	}
        	
        });
        
        end.setBounds(150, 150, 100, 30);
        end.setFont(font);
        end.setFocusable(false);
        
        //end.setEnabled(false);
        
        end.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		reset();
        		
        		//end.setEnabled(false);
        		//start.setEnabled(true);
        		
        	}
        	
        });
        
        
        window.add(start);
        window.add(end);
        window.add(label);
        window.add(area);

        window.getContentPane().setBackground(Color.GRAY);
        window.setLayout(null);  
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(300,300);
        window.setResizable(false);
        window.setVisible(true);
    	
    }
    
    public void avvia() {
    	timer.start();
    }
    
    public void fermo() {
    	timer.stop();
    	label.setText(" " + getCounter());
    }
    
    public void reset() {
    	setCounter(0);
    	label.setText(" " + getCounter());
    }
    
    public void setCounter(int counter) {
    	this.counter = counter;
    }
    
    public int getCounter() {
    	return counter;
    }
    
}
