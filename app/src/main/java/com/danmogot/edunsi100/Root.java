package com.danmogot.edunsi100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.danmogot.edunsi100.R;
import com.danmogot.edunsi100.libs.SoundPlayer;

public class Root extends AppCompatActivity {

    Button btnPlay, btnHelp, btnExit;
    private Session session;

    SoundPlayer soundPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        session = new Session(this);
        initViews();


        soundPlayer.playMusic(this);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Root.this, Level.class));
                soundPlayer.stopMediaPlayer();
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Root.this, Help.class));
                soundPlayer.stopMediaPlayer();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setId("");
                soundPlayer.stopMediaPlayer();
               startActivity(new Intent(getApplicationContext(), LoginRegister.class));
            }
        });
    }

    public void initViews() {
        btnPlay = findViewById(R.id.btnPlay);
        btnHelp = findViewById(R.id.btnHelp);
        btnExit = findViewById(R.id.btnExit);

        soundPlayer = new SoundPlayer(this);

    }
}
