import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProvaGUI extends JPanel{

    boolean startb = true;
    boolean endb = false;

    Cronometro cronometro = new Cronometro();
    JLabel label;
    JButton start = new JButton();
    JButton end = new JButton();

    public ProvaGUI() {
        setLayout(new GridLayout(0, 2));

        start = new JButton("Start");
        end = new JButton("End");
        /*
        start.setAlignmentX(3);
        start.setAlignmentY(3);
        */
        add(start);
        add(end);

        label = new JLabel("Cronometro: 0");
        add(label);
        
        start.setEnabled(true);
        end.setEnabled(false);

        

        start.addActionListener(new ActionListener() { //Pulsante di start cronometro

            @Override
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);
                startb = false;
                end.setEnabled(true);
                
                cronometro.start();
                label.setText("Cronometro: " + cronometro.str);
                
            }
            
        });

        end.addActionListener(new ActionListener() { //Pulsante di end cronometro

            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro.stop();

                end.setEnabled(false);
                start.setEnabled(true);
                
                label.setText("Cronometro: " + cronometro.str);
                
            }
            
        });
    }
    

    public static void main(String args[]) {
        JFrame myframe = new JFrame();
        ProvaGUI provagui = new ProvaGUI();

        myframe.getContentPane().add(provagui, BorderLayout.CENTER);
        myframe.setTitle("Hangman Game");
        myframe.pack();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLocationRelativeTo(null);
        myframe.setVisible(true);
    }
}