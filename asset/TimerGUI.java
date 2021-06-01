

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class TimerGUI extends JFrame{
	
	boolean started = false;

	JTextField textOre = new JTextField(2);
	JTextField textMinuti = new JTextField(2);
	JTextField textSecondi = new JTextField(2);
	JLabel labelOre = new JLabel();
	JLabel labelMinuti = new JLabel();
	JLabel labelSecondi = new JLabel();
	JButton start = new JButton("Start");
	JButton end= new JButton("Reset");
	JButton setTimer = new JButton("Set timer");
	JLabel label = new JLabel();
	TimerClock t = new TimerClock(label);
	
	TimerGUI() {
		
		super("TimerClock");
		
		label.setText("Tempo rimasto:  "+ t.str_ore + ":" + t.str_minuti + ":" + t.str_secondi);
		setLayout(null);
		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.GRAY);
		setResizable(false);
		
		
		 
		label.setBounds(65, 40, 150, 30);
		label.setBackground(Color.white);
		label.setEnabled(true);
		label.setOpaque(true);
		
		labelOre.setText("Ore");
		labelOre.setBounds(40, 200, 60, 30);
		labelOre.setEnabled(true);
		labelOre.setOpaque(true);
		labelOre.setBackground(Color.GRAY);

		labelMinuti.setText("Minuti");
		labelMinuti.setBounds(110, 200, 80, 30);
		labelMinuti.setEnabled(true);
		labelMinuti.setOpaque(true);
		labelMinuti.setBackground(Color.GRAY);

		labelSecondi.setText("Secondi");
		labelSecondi.setBounds(190, 200, 80, 30);
		labelSecondi.setEnabled(true);
		labelSecondi.setOpaque(true);
		labelSecondi.setBackground(Color.GRAY);

		textOre.setBounds(70, 205, 20, 20);
		add(textOre);
		
		textMinuti.setBounds(150, 205, 20, 20);
		add(textMinuti);
		
		textSecondi.setBounds(240, 205, 20, 20);
		add(textSecondi);
		
		start.setBounds(35, 100, 100, 30);
		end.setBounds(150, 100, 100, 30);
		setTimer.setBounds(95, 150, 100, 30);
		
		add(start);
		add(end);
		add(setTimer);
	    
		add(labelOre);
		add(labelMinuti);
		add(labelSecondi);
		add(label);
		setVisible(true);
		
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (!started) {
					started = true;
					start.setText("Stop");
					t.avvia();
				} else {
					started = false;
					start.setText("Start");
					t.fermo();
				}
				
			}
			
		});
		
		end.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				t.reset();
				start.setText("Start");
				
			}
			
		});
		
		setTimer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int ore;
				int minuti;
				int secondi;
				
				if (textOre.getText().equals("")) {
					textOre.setText("00");
				}
				ore = Integer.parseInt(textOre.getText());
				textOre.setText(numberToWord(ore));
				
				if (textMinuti.getText().equals("")) {
					textMinuti.setText("00");
				}
				minuti = Integer.parseInt(textMinuti.getText());
				textMinuti.setText(numberToWord(minuti));
				
				if (textSecondi.getText().equals("")) {
					textSecondi.setText("00");
				}
				secondi = Integer.parseInt(textSecondi.getText());
				textSecondi.setText(numberToWord(secondi));
				
				t.setOre(ore);
				t.setMinuti(minuti);
				t.setSecondi(secondi);
				
				String strO = String.format("%02d", ore);
				String strM = String.format("%02d", minuti);
				String strS = String.format("%02d", secondi);
				
				label.setText("Tempo rimasto:  "+ strO + ":" + strM + ":" + strS);
				System.out.println("  "+ strO + ":" + strM + ":" + strS);
				
				if (strO == "00" && strM == "00"  && strS == "00") {
					start.setText("Start");
				}
			}

			private String numberToWord(int minuti) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
	}
	
}
