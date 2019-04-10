package com.danmogot.edunsi100;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.danmogot.edunsi100.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends Fragment {
    private Session session;

    View view;

    Button btnLogin;

    EditText etEmail, etPassword;

    String id, tipe, ada, username, email, score, level;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login, container, false);
        session = new Session(getActivity());


        initViews();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            JSONObject jsonObject = jsonArray.getJSONObject(0);


                            ada = jsonObject.getString("ada");

                            if (ada.equals("1")) {
                                tipe = jsonObject.getString("tipe");

                                if (tipe.equals("user")) {
                                    id = jsonObject.getString("id");
                                    username = jsonObject.getString("username");
                                    email = jsonObject.getString("email");
                                    score = jsonObject.getString("score");
                                    level = jsonObject.getString("level");

                                    session.setId(id);
                                    session.setUsername(username);
                                    session.setEmail(email);
                                    session.setScore(score);
                                    session.setLevel(level);
                                    startActivity(new Intent(getActivity(), Tut.class));
                                } else {
                                    id = jsonObject.getString("id");
                                    username = jsonObject.getString("username");
                                    email = jsonObject.getString("email");

                                    session.setId(id);
                                    session.setUsername(username);
                                    session.setEmail(email);
                                    startActivity(new Intent(getActivity(), Admin.class));
                                }
                            } else {
                                Toast.makeText(getActivity(), "Login gagal, Coba lagi atau Silahkan register terlebih dahulu", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.d("Response", "res" + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "error Login" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("q", "login");
                        params.put("email", etEmail.getText().toString().trim());
                        params.put("password", etPassword.getText().toString().trim());
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(stringRequest);
            }
        });


        return view;
    }

    public void initViews() {
        btnLogin = view.findViewById(R.id.btnLogin);

        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
    }
}