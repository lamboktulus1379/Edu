package com.danmogot.edunsi100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danmogot.edunsi100.R;
import com.danmogot.edunsi100.libs.SoundPlayer;

public class Help extends AppCompatActivity {

    Button btnPlay, btnExit;
    public Session session;

    TextView tvJudul, tvText;
    LinearLayout llCaption;
    public SoundPlayer soundPlayer;

    ImageView ivOrganik, ivAnorganik, ivLogam, ivPlastik, ivKaca, ivKertasTumbuhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        session = new Session(this);

        initViews();
        soundPlayer.playMusic(this);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.stopMediaPlayer();
                startActivity(new Intent(Help.this, Level.class));
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.stopMediaPlayer();
                startActivity(new Intent(getApplicationContext(), LoginRegister.class));

                session.setId("");
            }
        });

        ivOrganik.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tvJudul.setText("Daun");
                    tvText.setText("Daun merupkan jenis sampah ORGANIK, masukkan ke dalam tong sampah ORGANIK, maka score akan bertambah, jika score sudah tercapai, maka level selanjutnya akan terbuka. " +
                            "Jika dimasukkan ke dalam tong sampah yang lain, maka miss akan bertambah!, jka miss bertambah, maka layar akan berubah, dan jika miss sama dengan 5, game akan berakhir!");

                    llCaption.setX(event.getX());
                    llCaption.setY(event.getY());
                    llCaption.setVisibility(View.VISIBLE);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    llCaption.setVisibility(View.GONE);
                }
                return true;
            }
        });

        ivAnorganik.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tvJudul.setText("Botol");
                    tvText.setText("Botol merupkan jenis sampah ANORGANIK, masukkan ke dalam tong sampah ANORGANIK, maka score akan bertambah, jika score sudah tercapai, maka level selanjutnya akan terbuka. " +
                            "Jika dimasukkan ke dalam tong sampah yang lain, maka miss akan bertambah!, jka miss bertambah, maka layar akan berubah, dan jika miss sama dengan 5, game akan berakhir!");

                    llCaption.setX(event.getX());
                    llCaption.setY(event.getY());
                    llCaption.setVisibility(View.VISIBLE);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    llCaption.setVisibility(View.GONE);
                }
                return true;
            }
        });

        ivPlastik.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tvJudul.setText("Plastik");
                    tvText.setText("Plastik merupkan jenis sampah PLASTIK, masukkan ke dalam tong sampah PLASTIK, maka score akan bertambah, jika score sudah tercapai, maka level selanjutnya akan terbuka. " +
                            "Jika dimasukkan ke dalam tong sampah yang lain, maka miss akan bertambah!, jka miss bertambah, maka layar akan berubah, dan jika miss sama dengan 5, game akan berakhir!");

                    llCaption.setX(event.getX());
                    llCaption.setY(event.getY());
                    llCaption.setVisibility(View.VISIBLE);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    llCaption.setVisibility(View.GONE);
                }
                return true;
            }
        });

        ivLogam.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tvJudul.setText("Kaleng");
                    tvText.setText("Kaleng terbuat dari LOGAM, masukkan ke dalam tong sampah LOGAM, maka score akan bertambah, jika score sudah tercapai, maka level selanjutnya akan terbuka. " +
                            "Jika dimasukkan ke dalam tong sampah yang lain, maka miss akan bertambah!, jka miss bertambah, maka layar akan berubah, dan jika miss sama dengan 5, game akan berakhir!");

                    llCaption.setX(event.getX());
                    llCaption.setY(event.getY());
                    llCaption.setVisibility(View.VISIBLE);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    llCaption.setVisibility(View.GONE);
                }
                return true;
            }
        });

        ivKaca.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tvJudul.setText("Piring Kaca");
                    tvText.setText("Piring Kaca terbuat dari KACA, masukkan ke dalam tong sampah KACA, maka score akan bertambah, jika score sudah tercapai, maka level selanjutnya akan terbuka. " +
                            "Jika dimasukkan ke dalam tong sampah yang lain, maka miss akan bertambah!, jka miss bertambah, maka layar akan berubah, dan jika miss sama dengan 5, game akan berakhir!");

                    llCaption.setX(event.getX());
                    llCaption.setY(event.getY());
                    llCaption.setVisibility(View.VISIBLE);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    llCaption.setVisibility(View.GONE);
                }
                return true;
            }
        });

        ivKertasTumbuhan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tvJudul.setText("Rumput");
                    tvText.setText("RUMPUT, merupkan jernis tumbuhan, masukkan RUMPUT ke dalam tong sampah bertuliskan Tumbuhan, maka score akan bertambah, jika score sudah tercapai, maka level selanjutnya akan terbuka. " +
                            "Jika dimasukkan ke dalam tong sampah yang lain, maka miss akan bertambah!, jka miss bertambah, maka layar akan berubah, dan jika miss sama dengan 5, game akan berakhir!");

                    llCaption.setX(event.getX());
                    llCaption.setY(event.getY());
                    llCaption.setVisibility(View.VISIBLE);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    llCaption.setVisibility(View.GONE);
                }
                return true;
            }
        });
    }

    public void initViews() {
        btnPlay = findViewById(R.id.btnPlay);
        btnExit = findViewById(R.id.btnExit);

        ivOrganik = findViewById(R.id.ivOrganik);
        ivAnorganik = findViewById(R.id.ivAnorganik);
        ivLogam = findViewById(R.id.ivLogam);
        ivPlastik = findViewById(R.id.ivPlastik);
        ivKaca = findViewById(R.id.ivKaca);
        ivKertasTumbuhan = findViewById(R.id.ivKertasTumbuhan);
        llCaption = findViewById(R.id.llCaption);
        soundPlayer = new SoundPlayer(this);

        tvJudul = findViewById(R.id.tvJudul);
        tvText = findViewById(R.id.tvText);
    }
}
