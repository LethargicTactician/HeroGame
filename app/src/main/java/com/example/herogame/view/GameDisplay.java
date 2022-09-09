package com.example.herogame.view;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.herogame.R;
import com.example.herogame.controller.GameLogic;
import com.example.herogame.models.Boss;
import com.example.herogame.models.Character;
import com.example.herogame.models.Hero;

import static android.view.View.VISIBLE;

//DISPLAYS AND MAKES THE OBJECTS IN ACTIVITY_MAIN.XML WORK
public class GameDisplay extends AppCompatActivity {
    GameLogic gl = new GameLogic();
    int counter;
    Button retryButton;
    TextView timerDisp;
    TextView viewHero;
    TextView viewBoss;
    Button attackBossButton;
    ImageView bossWinScreen;
    ImageView heroWinScreeen;
    ImageView remyInTheWay;
    ImageView heroBoi;

    //on click methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GAMEPLAY BUTTONS/DISPLAYS
        remyInTheWay = findViewById(R.id.remy);
        heroWinScreeen = findViewById(R.id.heroWin);
        bossWinScreen = findViewById(R.id.bossWin);
        timerDisp = findViewById(R.id.TimerDisplay);
        attackBossButton = findViewById(R.id.boss_click);
        heroBoi=findViewById(R.id.heroBoi);
        viewHero = findViewById(R.id.playerHP);
        viewBoss = findViewById(R.id.enemyHP);
        retryButton = findViewById(R.id.retryButton);

        //AFTERMATH (SET VISIBLE)
        retryButton.setVisibility(View.GONE);
        bossWinScreen.setVisibility(View.GONE);
        heroWinScreeen.setVisibility(View.GONE);
        attackBossButton.setVisibility(VISIBLE);
        heroBoi.setVisibility(VISIBLE);

    }

    //WHATEVER HAPPENS WHEN YOU CLICK THE BOSS
    public void onBossClick(View view) {
        counter = 5;
        gl.enemyTakeDamage();
        new CountDownTimer(4000, 1000) {
            public void onTick(long millisUnitFinished) {
                timerDisp.setText(String.valueOf(counter));
                counter--;

                if(counter == 1){
                    //HERO DAMAGE
                    gl.takeDamage();
                }
            }
            public void onFinish() {
                timerDisp.setText("PREPARE!");
            }

        }.start();
        hpDisplay();
        whoWon();
    }

    public void hpDisplay(){
        viewHero.setText(gl.heroHpDisplay());
        viewBoss.setText(gl.bossHpDisplay());
    }

    public void whoWon(){
        String justWon = gl.whoWins();
        if(justWon.equals("boss")){
            //boss wins
            //GameOver-lose.png
           visibleStuff();
           bossWinScreen.setVisibility(VISIBLE);
        }else if(justWon.equals("hero")){
            //hero wins
            //gameoverBossDeath.png
           visibleStuff();
           heroWinScreeen.setVisibility(VISIBLE);
        }
    }

    public void onRetryClick(View view){
        viewBoss.setText("8");
        viewHero.setText("6");
        gl.resetHP();
        retryButton.setVisibility(View.GONE);
        timerDisp.setVisibility(VISIBLE);
        attackBossButton.setEnabled(true);
        remyInTheWay.setVisibility(VISIBLE);
        heroBoi.setVisibility(VISIBLE);
        attackBossButton.setVisibility(VISIBLE);
        bossWinScreen.setVisibility(View.GONE);
        heroWinScreeen.setVisibility(View.GONE);
    }

    private void visibleStuff(){
        retryButton.setVisibility(VISIBLE);
        timerDisp.setVisibility(View.GONE);
        attackBossButton.setEnabled(false);
        remyInTheWay.setVisibility(View.GONE);
        heroBoi.setVisibility(View.GONE);
        attackBossButton.setVisibility(View.GONE);

    }
}
