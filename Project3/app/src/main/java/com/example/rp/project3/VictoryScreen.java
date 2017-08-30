package com.example.rp.project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VictoryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory_screen);
    }

    public void closeMe(View view)
    {
        finish();
    }

    public void goBack(View view)
    {
        Intent intent = new Intent(this,TitleScreen.class);
        startActivity(intent);
    }
}
