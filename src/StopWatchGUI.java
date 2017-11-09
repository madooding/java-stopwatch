import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by madooding on 11/9/2017 AD.
 */
public class StopWatchGUI extends JFrame {
    public StopWatchGUI(String watchName){
        Font font = new Font("Tahoma", Font.PLAIN, 80);
        this.setTitle(watchName + " by TA(s) of The Year");
        this.setBounds(100, 100, 600, 330);
        this.setLayout(null);


        JLabel minutes = new JLabel("0", SwingConstants.CENTER);
        JLabel seconds = new JLabel("0", SwingConstants.CENTER);
        JLabel ms = new JLabel("0", SwingConstants.CENTER);

        this.add(minutes);
        this.add(seconds);
        this.add(ms);

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

        this.add(startBtn);
        this.add(stopBtn);
        this.add(resetBtn);

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

        this.setVisible(true);
    }
    
}
