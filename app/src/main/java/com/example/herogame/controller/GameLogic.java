package com.example.herogame.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.herogame.MainActivity;
import com.example.herogame.R;
import com.example.herogame.models.Boss;
import com.example.herogame.models.Character;
import com.example.herogame.models.Hero;
import com.example.herogame.view.GameDisplay;

import java.io.File;
import java.util.Random;

public class GameLogic extends AppCompatActivity {
    Random random = new Random();
    private int hit;
    Character hero = new Hero();
    Character boss = new Boss();
    int hits = 0;
   MediaPlayer mp;

    //winner check
    public String whoWins(){
        String win = "";
        if(hero.getHp() == 0){
            //hero dies & boss is winner
            win="boss";
        }else if(boss.getHp() == 0){
            //boss dies & hero is winner
            win = "hero";

        }
        return win;
    }

    //reset game in case they pick retry
    public void resetHP(){
        //resets hero and boss hp
        //when user presses button to try again
        hero.setHp(6);
        boss.setHp(8);
        hits = 0;
    }

    public int takeDamage(){
        int dmg=boss.critChance();
        if(hits != 6){
            hits++;
            hero.setHp(hero.getHp() - dmg);
        }
        return hero.getHp();
    }

    public int enemyTakeDamage(){
        int dmg = hero.critChance();
        if(hits != 8){
            boss.setHp(boss.getHp() - dmg);
        } else if(boss.getHp() <= 0){
            boss.setHp(0);
        }
        return boss.getHp();
    }

    public String bossHpDisplay(){
        String bHealth = String.valueOf(boss.getHp());
        if(boss.getHp() <= 0){
            boss.setHp(0);
        }
        return bHealth;
    }
    public String heroHpDisplay(){
        String health = String.valueOf(hero.getHp());
        if(hero.getHp() <= 0){
            hero.setHp(0);
        }
       return health;
    }

   //GETTERS AND SETTERS JUST IN CASE
    public Random getRandom(){
        return random;
    }
    public void setRandom(Random random){
        this.random = random;
    }
    public int getHit() {
        return hit;
    }
    public void setHit(int hit) {
        this.hit = hit;
    }
}
