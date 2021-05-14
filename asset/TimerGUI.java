import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TimerGUI extends JPanel {
    JLabel promptLabel, timerLabel;
    final int count = 30;
    JButton start;
    JButton end;
    Timer timer;

    public TimerGUI() {
        
        JFrame myframe = new JFrame("Timer");
        
        myframe.getContentPane().setBackground(Color.GRAY);
        myframe.setLayout(null);  
        myframe.pack();
        myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myframe.setSize(300,300);
        myframe.setResizable(false);
        myframe.setVisible(true);



        setLayout(new GridLayout(0,2));

        start = new JButton("Start");
        add(start);
        Event e = new Event();
        start.addActionListener(e);

        end = new JButton("End");
        end.setEnabled(false);
        add(end);
        end.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                start.setEnabled(true);
                end.setEnabled(false);
                timerLabel.setText("Time Remaining " + count + " seconds");

            }

        });

        timerLabel = new JLabel("Time Remaining 30 seconds");
        add(timerLabel);

    }

    private class Event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            start.setEnabled(false);
            end.setEnabled(true);
            timerLabel.setText("Time Remaining " + count + " seconds");

            TimeClass tc = new TimeClass(count);
            timer = new Timer(1000, tc);
            timer.start();

        }
    }

    private class TimeClass implements ActionListener {
        int counter;

        public TimeClass(int count) {
            this.counter = count;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            counter--;
            
            
            if (counter >= 1) {
                timerLabel.setText("Time Remaining " + counter + " seconds");
            } else {    //Aggiuntere TrayIconDemo per l'avviso
                timer.stop();
                timerLabel.setText("game over");
            }

        }
    }

  



}