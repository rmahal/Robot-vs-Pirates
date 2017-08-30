package com.example.rp.project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

public class MainGame extends AppCompatActivity {
    ProgressBar bar;
    ProgressBar enemyBar;
    int damage = 0, lives = 5, n = 0;
    static int level = 1;
    TextView test, title;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        test = (TextView)findViewById(R.id.textView3);
        title = (TextView)findViewById(R.id.textView2);
        bar = (ProgressBar)findViewById(R.id.progressBar2);
        enemyBar = (ProgressBar)findViewById(R.id.progressBar3);
        bar.setIndeterminate(false);
        bar.setMax(150);
        bar.setProgress(0);
        enemyBar.setIndeterminate(false);
        enemyBar.setMax(500);
        enemyBar.setProgress(500);
        title.setText("Level " + level);
        test.setText("Lives: " + lives);
        new CountDownTimer(2500, 750) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
                if(bar.getProgress() >= 100)
                {
                    bar.setProgress(0);
                }
                if(enemyBar.getProgress() <= 0)
                {
                    win();
                    level++;
                    lives = 5;
                    title.setText("Level " + level);
                    test.setText("Lives: " + lives);
                    enemyBar.setProgress(500);
                }
                else if(lives < 0)
                {
                    level = 1;
                    lives = 5;
                    enemyBar.setProgress(500);
                    lose();
                }
                n = rand.nextInt(35);
                bar.incrementProgressBy((15 + n));
            }

            public void onFinish() {
                start();
            }

        }.start();
    }

    public void addProgress(View view) throws InterruptedException {
        damage = (bar.getProgress() * 3) / level;
        bar.setProgress(0);
        Thread.sleep(1000); // 1 seconds
        enemyBar.incrementProgressBy((damage * -1));
        lives--;
        test.setText("Lives: " + lives);
    }

    // Go to victory screen if you kill the enemy!
    public void win()
    {
        Intent intent2 = new Intent(this, VictoryScreen.class);
        startActivity(intent2);
    }

    // Go to game over screen if you run out of lives
    public void lose()
    {
        Intent intent3 = new Intent(this, GameOverScreen.class);
        startActivity(intent3);
    }
}
