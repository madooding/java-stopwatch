import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by madooding on 11/8/2017 AD.
 */
public class StopWatchMain {
    public static void main(String args[]){
        JFrame frame = new JFrame();
        Font font = new Font("Tahoma", Font.PLAIN, 80);
        frame.setTitle("StopWatch by TA(s) of The Year");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 330);
        frame.setLayout(null);


        JLabel minutes = new JLabel("0", SwingConstants.CENTER);
        JLabel seconds = new JLabel("0", SwingConstants.CENTER);
        JLabel ms = new JLabel("0", SwingConstants.CENTER);

        frame.add(minutes);
        frame.add(seconds);
        frame.add(ms);

        minutes.setFont(font);
        minutes.setBounds(100, 65, 120, 120);

        seconds.setFont(font);
        seconds.setBounds(240, 65, 120, 120);

        ms.setFont(font);
        ms.setBounds(380, 65, 120, 120);

        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");
        stopBtn.setEnabled(false);
        JButton resetBtn = new JButton("Reset");

        frame.add(startBtn);
        frame.add(stopBtn);
        frame.add(resetBtn);

        startBtn.setBounds(100, 205, 120, 20);
        stopBtn.setBounds(240, 205, 120, 20);
        resetBtn.setBounds(380, 205, 120, 20);
        
        StopWatchLogic logic = new StopWatchLogic(minutes, seconds, ms);
        logic.start();
        logic.suspend();

        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.resume();
                startBtn.setEnabled(false);
                stopBtn.setEnabled(true);
                startBtn.setText("Resume");
            }
        });

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.suspend();
                startBtn.setEnabled(true);
                stopBtn.setEnabled(false);
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.reset();
                startBtn.setText("Start");
                startBtn.setEnabled(true);
                stopBtn.setEnabled(false);
            }
        });

        frame.setVisible(true);
    }
}
