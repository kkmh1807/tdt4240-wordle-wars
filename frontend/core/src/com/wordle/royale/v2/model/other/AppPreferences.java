package com.wordle.royale.v2.model.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class AppPreferences {

    private static final String PREF_MUSIC_ENABLED = "music.enabled";
    private static final String PREFS_NAME = "wordleRoyale";

    Preferences prefs = Gdx.app.getPreferences(PREFS_NAME);

    public boolean getMusic(){
        return prefs.getBoolean(PREF_MUSIC_ENABLED);
    }

    public void setMusic(boolean musicInput){
        prefs.putBoolean(PREF_MUSIC_ENABLED, musicInput);
        prefs.flush();
        System.out.println(getMusic());
    }

}
