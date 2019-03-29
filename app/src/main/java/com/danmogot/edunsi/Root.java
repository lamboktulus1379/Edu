package com.danmogot.edunsi;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.danmogot.edunsi.R;
import com.danmogot.edunsi.libs.SoundPlayer;

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


        soundPlayer.playLegendary(this);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Root.this, Level.class));
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Root.this, Help.class));
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
