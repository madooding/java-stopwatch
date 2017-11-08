import javax.swing.*;

/**
 * Created by madooding on 11/8/2017 AD.
 */
public class StopWatchLogic extends Thread {
    private int minutes, seconds, ms;
    private JLabel minutesObj, secondsObj, msObj;
    private boolean isCounting = false;

    public StopWatchLogic(JLabel minutesObj, JLabel secondsObj, JLabel msObj){
        this.minutesObj = minutesObj;
        this.secondsObj = secondsObj;
        this.msObj = msObj;

    }

    public void run(){
        while(true){
            try {
                Thread.sleep(10);
                if(this.isCounting) {
                    this.ms++;
                    if (this.ms == 100) {
                        this.ms = 0;
                        this.seconds++;
                    }
                    if (this.seconds == 60) {
                        this.seconds = 0;
                        this.minutes++;
                    }
                    this.msObj.setText("" + this.ms);
                    this.secondsObj.setText("" + this.seconds);
                    this.minutesObj.setText("" + this.minutes);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
        }
    }

    public void startWatch(){
        this.isCounting = true;
    }

    public void stopWatch(){
        this.isCounting = false;
    }

    public void resetWatch(){
        this.stopWatch();
        this.minutes = 0;
        this.seconds = 0;
        this.ms = 0;
        this.msObj.setText("" + this.ms);
        this.secondsObj.setText("" + this.seconds);
        this.minutesObj.setText("" + this.minutes);
    }
}
