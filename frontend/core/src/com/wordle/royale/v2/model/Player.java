package com.wordle.royale.v2.model;

public class Player extends User {

    private static Player player = null;
    private Player() {
        super();
    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return  player;
    }

    public Player setName(String name) {
        player.userName = name;
        return player;
    }


}


