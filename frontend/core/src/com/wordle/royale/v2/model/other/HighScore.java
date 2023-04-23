package com.wordle.royale.v2.model.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore {
    private ArrayList<Score> highscores = new ArrayList<>();
    private BitmapFont font;

    private Score score1 = new Score(101, "Ola");
    private Score score2 = new Score(40, "Kari");
    private Score score3 = new Score(70, "Per");
    private Score score4 = new Score(330, "Mohammed");
    private Score score5 = new Score(100, "Pål");

    public HighScore() {
        font = new BitmapFont();
        font.getData().setScale(4f, 4f);
        highscores.add(score1);
        highscores.add(score2);
        highscores.add(score3);
        highscores.add(score4);
        highscores.add(score5);
    }

    public void render(SpriteBatch batch) {
        Collections.sort(highscores);
        for (int i = 0; i < highscores.size(); i++) {
            float xPos = Gdx.graphics.getWidth() / 4f;
            float yPos = Gdx.graphics.getHeight() / 1.5f  - (i*75);
            String text = (i + 1) + ". " + highscores.get(i).toString();
            font.draw(batch, text, xPos, yPos);
        }
    }
}
