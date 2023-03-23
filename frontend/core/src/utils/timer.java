package utils;


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class timer {
    static int interval;
    static Timer timer;

    public void start() {
        int secs = 5*60;
        timer = new Timer();
        interval = secs;
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                setInterval();
            }
        }, 1000, 1000);
    }

    public static String getInterval() {
        int min = interval / 60 ;
        int sec = ((interval % 86400) % 3600) % 60;

        if (sec < 10) {
            return min + ":0"  + sec;
        }
        else {
            return min + ":"  + sec;
        }

    }

    public static int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }

    public void stop() {
        timer.cancel();
    }
}


