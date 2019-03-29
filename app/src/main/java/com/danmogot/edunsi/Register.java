package com.danmogot.edunsi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class Register extends Fragment {
    View view;

    Button btnRegister;

    EditText etUsername, etPassword, etConfirmPassword, etEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.register, container, false);

        initViews();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty() || etConfirmPassword.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Isi semua", Toast.LENGTH_SHORT).show();
                } else if (!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
                    Toast.makeText(getActivity(), "Password tidak sama!", Toast.LENGTH_SHORT).show();
                } else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);

                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(getActivity(), "Anda berhasil mendaftar! Silahkan login", Toast.LENGTH_SHORT).show();
                            startActivity(getActivity().getIntent());
                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(), "error Register" + error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("q", "register");
                            params.put("username", etUsername.getText().toString());
                            params.put("email", etEmail.getText().toString());
                            params.put("password", etPassword.getText().toString());
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(stringRequest);
                }
            }
        });

        return view;
    }

    public void initViews() {
        btnRegister = view.findViewById(R.id.btnRegister);

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        etConfirmPassword = view.findViewById(R.id.etConfirmPassword);
        etEmail = view.findViewById(R.id.etEmail);
    }
}
