package com.wordle.royale.v2.model.utils;
import com.wordle.royale.v2.presenter.ITimerObserver;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class WordleTimer {

    private static ArrayList<ITimerObserver> observers;
    static int interval;
    static Timer timer;
    private static WordleTimer instance = null;

    private WordleTimer() {
        interval = 5*60;
        observers = new ArrayList<ITimerObserver>();
    }

    public void addObserver(ITimerObserver observer){
        observers.add(observer);
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
        if (interval == 1) {
            for (ITimerObserver observer: observers) {
                System.out.println("Notified");
                observer.timeUp(true);
            }
            instance.stop();
        }
        return --interval;
    }

    public void stop() {
        timer.cancel();
        instance = null;
    }
}


