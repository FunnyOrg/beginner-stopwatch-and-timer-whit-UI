import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Menu extends JFrame{

    
    JButton t = new JButton("Timer");
    JButton c = new JButton("Cronometro");
    JLabel label = new JLabel();
    Font font = new Font("Verdana", Font.PLAIN, 15);
    

    public Menu() {
    	
    	super("Menu");
        
     
    	setLayout(null);
        getContentPane().setBackground(Color.GRAY);
		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setBackground(Color.RED);
		setResizable(false);
		
    
        t.setBounds(40, 20, 200, 100);
        t.setFont(font);
        t.setFocusable(false);

        t.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				TimerGUI tg = new TimerGUI();
			}
        	
        	
        	
        });
        
        c.setBounds(40, 130, 200, 100);
        c.setFont(font);
        c.setFocusable(false);
        
        c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Stopwatch st = new Stopwatch();
			}
        	
        	
        });
        
        add(t);
        add(c);
        add(label);
        setVisible(true);

     
    }

   
}
