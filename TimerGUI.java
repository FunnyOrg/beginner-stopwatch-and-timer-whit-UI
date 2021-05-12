import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerGUI extends JPanel {
    JLabel promptLabel, timerLabel;
    final int count = 30;
    JButton start;
    JButton end;
    Timer timer;

    public TimerGUI() {
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
            if (counter <= 5) {
                Toolkit.getDefaultToolkit().beep();
            }

            if (counter >= 1) {
                timerLabel.setText("Time Remaining " + counter + " seconds");
            } else {
                timer.stop();
                timerLabel.setText("game over");
            }

        }
    }

    public static void main(String[] args) {
        JFrame myframe = new JFrame();
        TimerGUI timer = new TimerGUI();
        // myframe.getContentPane().add(content,BorderLayout.CENTER);
        myframe.getContentPane().add(timer, BorderLayout.CENTER);
        myframe.setTitle("Hangman Game");
        myframe.pack();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLocationRelativeTo(null);
        myframe.setVisible(true);

    }

}