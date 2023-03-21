package com.wordle.royale;

public class Score implements Comparable<Score> {
    public int score;
    public String name;

    public Score() {
        score = 0;
        name = "";
    }

    public Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public String toString() {
        return name + ": " + score;
    }
    @Override
    public int compareTo(Score s) {
        if (score > s.score) {
            return score;
        }
        return -1;
    }
}
