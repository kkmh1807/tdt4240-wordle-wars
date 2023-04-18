package com.wordle.royale.test.models.utils;
import java.util.Timer;
import java.util.TimerTask;

public class WordleTimer {
    static int interval;
    static Timer timer;
    private static WordleTimer instance = null;

    private WordleTimer() {
        interval = 5*60;
    }


    public void start() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                setInterval();
            }
        }, 1000, 1000);
    }
    public static WordleTimer getInstance() {
        if (instance == null) {
            instance = new WordleTimer();
        }
        return instance;
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
        if (interval == 0) {
            timer.cancel();
            instance = null;
        }
        return --interval;
    }

    public void stop() {
        timer.cancel();
        instance = null;
    }
}


