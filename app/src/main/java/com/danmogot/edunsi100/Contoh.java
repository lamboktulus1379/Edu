package com.danmogot.edunsi100;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Contoh extends Fragment {
    View view;

    ContohListener activityCommander;

    public interface ContohListener {
        void onCreateClickContoh();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCommander = (ContohListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }
    Button btnSelanjutnya;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.contoh, container, false);
        initViews();
        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityCommander.onCreateClickContoh();
            }
        });

        return view;
    }

    public void initViews() {
        btnSelanjutnya = view.findViewById(R.id.btnSelanjutnya);
    }
}
