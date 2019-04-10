package com.danmogot.edunsi100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.danmogot.edunsi100.libs.SoundPlayer;
import com.danmogot.edunsi100.R;


public class Level extends AppCompatActivity {

    private Session session;

    private SoundPlayer soundPlayer;
    String currentScore, currentLevel;

    Button btnLevelOne, btnLevelTwo, btnLevelThree, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_level);

        initViews();

        soundPlayer.playMusic(getApplicationContext());
        session = new Session(this);

        if (session.getId().equals("")) {
            startActivity(new Intent(getApplicationContext(), LoginRegister.class));
        }

        currentScore = session.getScore();
        currentLevel = session.getLevel();


        final String[] scoreSplit = currentScore.split(",");


        btnLevelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.stopMediaPlayer();
                if (Integer.valueOf(currentLevel) >= 1) {
                    Intent intentLevelOne = new Intent(Level.this, MainActivity.class);
                    intentLevelOne.putExtra("high_score", scoreSplit[0]);
                    intentLevelOne.putExtra("level", 1);
                    startActivity(intentLevelOne);
                } else {
                    Toast.makeText(Level.this, "Unknown Error, Contact your Administrator!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnLevelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.stopMediaPlayer();
                if (Integer.valueOf(currentLevel) >= 2) {
                    Intent intentLevelTwo = new Intent(Level.this, MainActivity.class);
                    intentLevelTwo.putExtra("high_score", scoreSplit[1]);
                    intentLevelTwo.putExtra("level", 2);
                    startActivity(intentLevelTwo);
                } else {
                    Toast.makeText(Level.this, "Anda harus menyelesaikan level 1 terlebih dahulu.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLevelThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.stopMediaPlayer();
                if (Integer.valueOf(currentLevel) >= 3) {
                    Intent intentLevelThree = new Intent(Level.this, MainActivity.class);
                    intentLevelThree.putExtra("high_score", scoreSplit[2]);
                    intentLevelThree.putExtra("level", 3);
                    startActivity(intentLevelThree);
                } else {
                    Toast.makeText(Level.this, "Anda harus menyelesaikan level 1 dan level 2 terlebih dahulu.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.stopMediaPlayer();
                session.setId("");
                startActivity(new Intent(getApplicationContext(), LoginRegister.class));
            }
        });
    }

    public void initViews() {
        btnLevelOne = findViewById(R.id.btnLevelOne);
        btnLevelTwo = findViewById(R.id.btnLevelTwo);
        btnLevelThree = findViewById(R.id.btnLevelThree);
        btnQuit = findViewById(R.id.btnQuit);

        soundPlayer = new SoundPlayer(getApplicationContext());
    }
}