package timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();

        System.out.println("thread in main: "+ Thread.currentThread().getName());
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task is running ...");
                System.out.println("thread in run: "+ Thread.currentThread().getName());
            }
        };

        timer.schedule(task,100);
        task.cancel();
//        timer.cancel();

    }
}
