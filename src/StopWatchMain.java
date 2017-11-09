import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by madooding on 11/8/2017 AD.
 */
public class StopWatchMain {
    private static int counter = 1;
    public static void main(String args[]){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Main");
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        JButton newBtn = new JButton("new watch");
        newBtn.setBounds(125,125,250, 250);
        mainFrame.add(newBtn);

        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StopWatchGUI watch = new StopWatchGUI("StopWatch " + counter++);
            }
        });

        mainFrame.setVisible(true);
    }
}
