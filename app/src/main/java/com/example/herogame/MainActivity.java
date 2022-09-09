package com.example.herogame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.herogame.models.Boss;
import com.example.herogame.models.Hero;
import com.example.herogame.view.GameDisplay;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_menu);
        }
        public void playButtonClick (View view){
            Intent intent = new Intent(this, GameDisplay.class);
            startActivity(intent);
        }

}