import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JFrame;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerClock {
	TrayIconDemo notifica = new TrayIconDemo(); 
	JLabel labelTimer = new JLabel();
	JFrame frame = new JFrame("Timer");
	public boolean fine = false;
	private int ore;
	private int minuti;
	private int secondi;
	String str_ore;
	String str_minuti;
	String str_secondi;
	Timer timer;
	
	TimerClock(JLabel label) {
		
		labelTimer = label;
		this.ore = 0;
		this.minuti = 0;
		this.secondi = 0;
		str_ore = String.format("%02d", getOre());
		str_minuti = String.format("%02d", getMinuti());
		str_secondi = String.format("%02d", getSecondi());
		
		timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
					if (getSecondi() > 0) {
						setSecondi(getSecondi()-1);
					} else if (getMinuti() > 0) {
						setMinuti(getMinuti()-1);
						setSecondi(59);
					} else if (getOre() > 0) {
						setOre(getOre()-1);
						setMinuti(59);
						setSecondi(59);
					} else {

						timer.stop();
						try {
							notifica.displayTray();
						} catch (AWTException Eccezione) {
							Eccezione.printStackTrace();
						}
					}
					
					str_ore = String.format("%02d", getOre());
					str_minuti = String.format("%02d", getMinuti());
					str_secondi = String.format("%02d", getSecondi());
					
					labelTimer.setText("Tempo rimasto:  "+ str_ore + ":" + str_minuti + ":" + str_secondi);
					System.out.println("  "+ str_ore + ":" + str_minuti + ":" + str_secondi);
				
				
			}	
		});
		
	}
	
	public void avvia() {
		timer.start();
	}
	
	public void fermo() {
		timer.stop();
	}
	
	public void reset() {
		timer.stop();
		setOre(0);
		setMinuti(0);
		setSecondi(0);
		str_ore = String.format("%02d", getOre());
		str_minuti = String.format("%02d", getMinuti());
		str_secondi = String.format("%02d", getSecondi());
		labelTimer.setText("Tempo rimasto:  "+ str_ore + ":" + str_minuti + ":" + str_secondi);
		System.out.println("  "+ str_ore + ":" + str_minuti + ":" + str_secondi);
	}
	
	public void setOre(int ore) {
		this.ore = ore;
	}
	
	public int getOre() {
		return ore;
	}
	
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	
	public int getMinuti() {
		return minuti;
	}
	
	public void setSecondi(int secondi) {
		this.secondi = secondi;
	}
	
	public int getSecondi() {
		return secondi;
	}
	
}

