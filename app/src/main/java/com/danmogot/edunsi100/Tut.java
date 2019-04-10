package com.danmogot.edunsi100;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.danmogot.edunsi100.libs.SoundPlayer;


public class Tut extends AppCompatActivity implements
        Jenis.JenisListener,
        Contoh.ContohListener,
        Home.HomeListener {

    FrameLayout frameUF;
    FragmentManager fragmentManager;
    Animation slide_right;

    public SoundPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tut);
        initViews();
        soundPlayer.playMusic(this);


        fragmentManager = getSupportFragmentManager();
        slide_right =  AnimationUtils.loadAnimation(Tut.this, R.anim.slide_right);;

        frameUF.startAnimation(slide_right);
        frameUF.setVisibility(View.VISIBLE);
        Home home = new Home();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameUF, home, "home");
        fragmentTransaction.addToBackStack("home");
        fragmentTransaction.commit();

    }

    public void initViews() {

        frameUF = findViewById(R.id.frameUF);
        soundPlayer = new SoundPlayer(this);
    }

    @Override
    public void onCreateClickJenis() {
        frameUF.startAnimation(slide_right);
        frameUF.setVisibility(View.VISIBLE);
        Contoh contoh = new Contoh();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameUF, contoh, "contoh");
        fragmentTransaction.addToBackStack("contoh");
        fragmentTransaction.commit();
    }

    @Override
    public void onCreateClickContoh() {
        soundPlayer.stopMediaPlayer();
        startActivity(new Intent(Tut.this, Root.class));
    }

    @Override
    public void onCreateClickHome() {
        frameUF.startAnimation(slide_right);
        frameUF.setVisibility(View.VISIBLE);
        Jenis jenis = new Jenis();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameUF, jenis, "jenis");
        fragmentTransaction.addToBackStack("jenis");
        fragmentTransaction.commit();
    }
}
