package com.example.herogame.models;

import android.speech.SpeechRecognizer;

import java.util.Random;

public abstract class Character {

    Random random = new Random();
    int hp;
    int attack;
//    int attkSpd;
    String name;

    protected int roll(int numberOfDice,int numberOfSides){
        int total = 0;
        for (int i = 0; i < numberOfDice; i++)
            total += random.nextInt(numberOfSides);
        return total;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int critChance();
}
