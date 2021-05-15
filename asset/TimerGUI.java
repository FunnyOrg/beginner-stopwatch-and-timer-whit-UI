package asset;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class TimerGUI {
	
	boolean started = false;
    JLabel label, timerLabel;
    JButton start = new JButton("start");
    JFrame window = new JFrame("Timer");
    JButton end = new JButton("end");
    int counter = 30;
    Timer timer;
    Font font = new Font("Verdana", Font.PLAIN, 15);
    
    public TimerGUI() {
    	
    	timer = new Timer(1000, new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			counter--;
    			if(getCounter() == 0) {
    				fermo();
    			}
    			label.setText("   Tempo rimasto: " + getCounter());
    		}
    		
    	});
    	
    	label = new JLabel("   Tempo rimasto: 0");
    	label.setBounds(50, 60, 180, 30);
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setEnabled(true);
        label.setVisible(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setOpaque(true);
        
        start.setBounds(35, 150, 100, 30);
        start.setFont(font);
        start.setFocusable(false);
       
        //start.setEnabled(true);
        
        
        start.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		//if(e.getSource() == start) {
        			if(started == false) {
        				started = true;
        				start.setText("Stop");
        				avvia();
        			} else {
        				started = false;
        				start.setText("Start");
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
    	label.setText("   Tempo rimasto: " + getCounter());
    }
    
    public void reset() {
    	setCounter(0);
    	label.setText("   Tempo rimasto: " + getCounter());
    }
    
    public void setCounter(int counter) {
    	this.counter = counter;
    }
    
    public int getCounter() {
    	return counter;
    }
    
}

