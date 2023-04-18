package com.wordle.royale.model;

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
        if(score > s.score) {
            return -1;
        } else if (score < s.score) {
            return 1;
        }
        else {
            return name.compareTo(s.name);
        }
    }
}
