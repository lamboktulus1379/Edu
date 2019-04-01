package com.danmogot.edunsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.danmogot.edunsi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WinLose extends AppCompatActivity {

    private Session session;

    TextView tvMessage;
    Button btnChooseLevel;
    Button btnQuit;

    String message;
    int level, score, totalScore;
    long time, total;

    String id, scoreS, levelS, scoreToSend;
    String currentScore, currentLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose);
        session = new Session(this);
        id = session.getId();
        currentScore = session.getScore();
        currentLevel = session.getLevel();

        initViews();

        message = getIntent().getStringExtra("message");
        level = getIntent().getIntExtra("level", 0);
        score = getIntent().getIntExtra("score", 0);
        Long stime = getIntent().getLongExtra("time", 1);
        if (stime >= 1000L) {
            time = stime / 1000L;
        } else {
            time = stime;
        }
        tvMessage.setText("Highscore: " + score + " Level: " + level);

        String[] scoreSplit = currentScore.split(",");
        scoreS = String.valueOf(score);


        if (level == 1) {
            if (score >= 200) {
                level = 2;
            }
            scoreSplit[0] = String.valueOf(time * score);
        } else if (level == 2  ) {
            if (score >= 300) {
                level = 3;
            }
            scoreSplit[1] = String.valueOf(time * score);
        } else if (level == 3  ) {
            if (score >= 400) {
                level = 3;
            }
            scoreSplit[2] = String.valueOf(time * score);
        }


        if (level > Integer.valueOf(currentLevel)) {
            levelS = String.valueOf(level);
        } else {
            levelS = currentLevel;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scoreSplit.length; i++) {
            sb.append(scoreSplit[i]);
            if (i != scoreSplit.length - 1) {
                sb.append(",");
            }
        }
        scoreToSend = sb.toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("q", "update");
                params.put("who", "user");
                params.put("id", id);
                params.put("score", scoreToSend);
                params.put("level", levelS);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(WinLose.this);
        requestQueue.add(stringRequest);

        session.setLevel(levelS);
        session.setScore(scoreToSend);

        tvMessage.setText(message);

        btnChooseLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WinLose.this, Level.class));
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginRegister.class));
                session.setId("0");
            }
        });
    }

    public void initViews() {
        tvMessage = findViewById(R.id.tvMessage);
        btnChooseLevel = findViewById(R.id.btnChooseLevel);
        btnQuit = findViewById(R.id.btnQuit);
    }
}
