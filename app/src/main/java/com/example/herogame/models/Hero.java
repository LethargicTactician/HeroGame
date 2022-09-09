package com.example.herogame.models;

import com.example.herogame.models.Character;

public class Hero extends Character {
    public Hero() {
        setAttack(1);
        setHp(6);
        setName("Mr.Hero");
    }

    @Override
    public int critChance() {
        int dmg=0;
        int chance=roll(1,10);
        if(chance>8 && chance<=10){
            //crit
            dmg=attack*2;
            return dmg;
        }else if(chance> 3 && chance <= 8){
            //normal hit
            dmg=attack;
            return dmg;
        } else {
            //miss
            return dmg;
        }

    }
}
