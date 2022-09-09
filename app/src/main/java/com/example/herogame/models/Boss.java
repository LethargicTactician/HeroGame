package com.example.herogame.models;

import java.util.Timer;
import java.util.TimerTask;

public class Boss extends Character {

    public Boss(){
        setName("Impostor");
        setAttack(2);
        setHp(8);
    }

    @Override
    protected int roll(int numberOfDice, int numberOfSides) {
        return super.roll(numberOfDice, numberOfSides);
    }

    @Override
    public int critChance() {
        int dmg=1;
        int chance = roll(1, 10);
        if (chance > 8 && chance <= 10) {
            //crit
            dmg = attack * 6;
            return dmg;
        } else if (chance > 1 && chance <= 8) {
            //normal hit
            dmg = attack;
            return dmg;
        } else {
            //miss
            return dmg;
        }
    }
}
