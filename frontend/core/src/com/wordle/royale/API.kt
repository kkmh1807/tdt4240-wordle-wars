package com.wordle.royale

import java.util.ArrayList;

interface API {
    fun submitHighscore(score: Number)
    fun getHighscores(data: ArrayList<Number>)
}