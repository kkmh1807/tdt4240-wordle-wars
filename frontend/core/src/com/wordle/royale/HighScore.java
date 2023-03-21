package com.wordle.royale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class HighScore {
    private ArrayList<Score> highscores = new ArrayList<>();
    private BitmapFont font;

    private Score score1 = new Score(1, "Ola");
    private Score score2 = new Score(2, "Kari");
    private Score score3 = new Score(3, "Per");
    private Score score4 = new Score(4, "Mohammed");
    private Score score5 = new Score(5, "Pål");

    public HighScore() {
        font = new BitmapFont();
        font.getData().setScale(2f);
        highscores.add(score1);
        highscores.add(score2);
        highscores.add(score3);
        highscores.add(score4);
        highscores.add(score5);
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < highscores.size(); i++) {
            int xPos = Gdx.graphics.getWidth() / 2 - 30;
            int yPos = Gdx.graphics.getHeight() - 100 - (i * 50);
            String text = (i + 1) + ". " + highscores.get(i).toString();
            font.draw(batch, text, xPos, yPos);
        }
    }
}
