package com.danmogot.edunsi100;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Jenis extends Fragment {

    View view;

    JenisListener activityCommander;

    public interface JenisListener {
        void onCreateClickJenis();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCommander = (JenisListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    CountDownTimer countDownTimer;
    Button btnSelanjutnya;

    TextView tvOrganik, tvAnorganik, tvPlastik;
    TextView tvContentOrganik, tvContentAnorganik , tvContentPlastik;

    Animation slide_right, fadein;

    int i = 1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.jenis, container, false);
        initViews();
        slide_right = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        fadein = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);

        countDownTimer = new CountDownTimer(6000000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        }.start();

        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    tvOrganik.startAnimation(slide_right);
                    tvOrganik.setVisibility(View.VISIBLE);
                } else if (i == 2) {
                    tvContentOrganik.startAnimation(fadein);
                    tvContentOrganik.setVisibility(View.VISIBLE);
                } else if (i == 3) {
                    tvAnorganik.startAnimation(slide_right);
                    tvAnorganik.setVisibility(View.VISIBLE);
                } else if (i == 4) {
                    tvContentAnorganik.startAnimation(fadein);
                    tvContentAnorganik.setVisibility(View.VISIBLE);
                } else if (i == 5) {
                    tvPlastik.startAnimation(slide_right);
                    tvPlastik.setVisibility(View.VISIBLE);
                } else if (i == 6) {
                    tvContentPlastik.startAnimation(fadein);
                    tvContentPlastik.setVisibility(View.VISIBLE);
                } else {
                    activityCommander.onCreateClickJenis();
                }

                i++;
            }
        });


        return view;
    }

    public void initViews() {
        btnSelanjutnya = view.findViewById(R.id.btnSelanjutnya);
        tvOrganik = view.findViewById(R.id.tvOrganik);
        tvAnorganik = view.findViewById(R.id.tvAnorganik);
        tvPlastik = view.findViewById(R.id.tvPlastik);

        tvContentOrganik = view.findViewById(R.id.tvContentOrganik);
        tvContentAnorganik = view.findViewById(R.id.tvContentAnorganik);
        tvContentPlastik = view.findViewById(R.id.tvContentPlastik);
    }
}
