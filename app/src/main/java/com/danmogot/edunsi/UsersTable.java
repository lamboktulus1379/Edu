package com.danmogot.edunsi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersTable extends Fragment implements View.OnClickListener {

    View view;

    String id, username, email, password, score, level;
    String usernameEdit = null, emailEdit = null, passwordEdit = null, scoreEdit = null, levelEdit = null;

    TableLayout tlUsers;

    ArrayList<Button> btnEditUsers = new ArrayList<Button>();
    ArrayList<Button> btnDeleteUsers = new ArrayList<Button>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.table_users, container, false);

        initViews();

        final TableRow trUsers = new TableRow(getActivity());
        TextView tvHeaderId = new TextView(getActivity());
        TextView tvHeaderUsername = new TextView(getActivity());
        TextView tvHeaderEmail = new TextView(getActivity());
        TextView tvHeaderPassword = new TextView(getActivity());
        TextView tvHeaderScore = new TextView(getActivity());
        TextView tvHeaderLevel = new TextView(getActivity());
        TextView tvHeaderAction = new TextView(getActivity());

        tvHeaderId.setText("ID");
        tvHeaderUsername.setText("Username");
        tvHeaderEmail.setText("Email");
        tvHeaderPassword.setText("Password");
        tvHeaderScore.setText("Score");
        tvHeaderLevel.setText("Level");
        tvHeaderAction.setText("Action");

        tvHeaderId.setPadding(5, 1, 5, 1);
        tvHeaderUsername.setPadding(5, 1, 5, 1);
        tvHeaderEmail.setPadding(5, 1, 5, 1);
        tvHeaderPassword.setPadding(5, 1, 5, 1);
        tvHeaderScore.setPadding(5, 1, 5, 1);
        tvHeaderLevel.setPadding(5, 1, 5, 1);
        tvHeaderAction.setPadding(5, 1, 5, 1);

        trUsers.addView(tvHeaderId);
        trUsers.addView(tvHeaderUsername);
        trUsers.addView(tvHeaderEmail);
        trUsers.addView(tvHeaderPassword);
        trUsers.addView(tvHeaderScore);
        trUsers.addView(tvHeaderLevel);
        trUsers.addView(tvHeaderAction);

        tlUsers.addView(trUsers, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        id = jsonObject.getString("id");
                        username = jsonObject.getString("username");
                        password = jsonObject.getString("password");
                        email = jsonObject.getString("email");
                        score = jsonObject.getString("score");
                        level = jsonObject.getString("level");

                        TableRow trUsers = new TableRow(getActivity());

                        if (i % 2 == 0) {
                            trUsers.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        }

                        TextView tvId = new TextView(getActivity());
                        tvId.setText(id);
                        tvId.setPadding(5, 5, 1, 5);
                        trUsers.addView(tvId);

                        TextView tvUsername = new TextView(getActivity());
                        tvUsername.setText(username);
                        tvUsername.setPadding(5, 5, 1, 5);
                        trUsers.addView(tvUsername);

                        TextView tvEmail = new TextView(getActivity());
                        tvEmail.setText(email);
                        tvEmail.setPadding(5, 5, 1, 5);
                        trUsers.addView(tvEmail);

                        TextView tvPassword = new TextView(getActivity());
                        tvPassword.setText(password);
                        tvPassword.setPadding(5, 5, 1, 5);
                        trUsers.addView(tvPassword);

                        TextView tvScore = new TextView(getActivity());
                        tvScore.setText(score);
                        tvScore.setPadding(5, 5, 1, 5);
                        trUsers.addView(tvScore);

                        TextView tvLevel = new TextView(getActivity());
                        tvLevel.setText(level);
                        tvLevel.setPadding(5, 5, 1, 5);
                        trUsers.addView(tvLevel);


                        btnEditUsers.add(i, new Button(getActivity()));
                        btnEditUsers.get(i).setId(Integer.parseInt(id));
                        btnEditUsers.get(i).setTag("Edit");
                        btnEditUsers.get(i).setText("Edit");
                        btnEditUsers.get(i).setOnClickListener(UsersTable.this);
                        trUsers.addView(btnEditUsers.get(i));

                        btnDeleteUsers.add(i, new Button(getActivity()));
                        btnDeleteUsers.get(i).setId(Integer.parseInt(id));
                        btnDeleteUsers.get(i).setTag("Delete");
                        btnDeleteUsers.get(i).setText("Delete");
                        btnDeleteUsers.get(i).setOnClickListener(UsersTable.this);
                        trUsers.addView(btnDeleteUsers.get(i));

                        tlUsers.addView(trUsers, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
                params.put("q", "admin");
                params.put("table", "users");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

        return view;
    }

    public void initViews() {
        tlUsers = view.findViewById(R.id.tlUsers);
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < btnEditUsers.size(); i++) {
            if (v.getId() == btnEditUsers.get(i).getId() && v.getTag().toString().trim().equals("Edit")) {

                int id = btnEditUsers.get(i).getId();
                getUsersById(id);
            } else if (v.getId() == btnDeleteUsers.get(i).getId() && v.getTag().toString().trim().equals("Delete")) {
                int id = btnDeleteUsers.get(i).getId();
                deleteUsers(id);
            }
        }
    }

    public void deleteUsers(final int id) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "Data Users berhasil dihapus!", Toast.LENGTH_SHORT).show();
                startActivity(getActivity().getIntent());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "error " + error, Toast.LENGTH_LONG).show();
                startActivity(getActivity().getIntent());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("q", "delete");
                params.put("table", "users");
                params.put("id", String.valueOf(id));
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    public void getUsersById(final int id) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    usernameEdit = jsonObject.getString("username");
                    passwordEdit = jsonObject.getString("password");
                    emailEdit = jsonObject.getString("email");
                    scoreEdit = jsonObject.getString("score");
                    levelEdit = jsonObject.getString("level");



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LinearLayout llInputEditUser = new LinearLayout(getActivity());
                llInputEditUser.setOrientation(LinearLayout.VERTICAL);

                final TextView tvId = new TextView(getActivity());
                tvId.setText(String.valueOf(id));
                tvId.setTextColor(Color.TRANSPARENT);
                llInputEditUser.addView(tvId);

                final EditText etUsername = new EditText(getActivity());
                etUsername.setText(usernameEdit);
                llInputEditUser.addView(etUsername);

                final EditText etEmail = new EditText(getActivity());
                etEmail.setText(emailEdit);
                llInputEditUser.addView(etEmail);

                final EditText etPassword = new EditText(getActivity());
                etPassword.setText(passwordEdit);
                llInputEditUser.addView(etPassword);

                final EditText etScore = new EditText(getActivity());
                etScore.setText(scoreEdit);
                llInputEditUser.addView(etScore);

                final EditText etLevel = new EditText(getActivity());
                etLevel.setText(levelEdit);
                llInputEditUser.addView(etLevel);

                AlertDialog.Builder builderEditUsers = new AlertDialog.Builder(getActivity());
                builderEditUsers.setIcon(R.drawable.ic_edit_primary_24dp);
                builderEditUsers.setTitle("Update Users");
                builderEditUsers.setView(llInputEditUser);
                builderEditUsers.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String id = tvId.getText().toString();
                        final String username = etUsername.getText().toString();
                        final String email = etEmail.getText().toString();
                        final String password = etPassword.getText().toString();
                        final String score = etScore.getText().toString();
                        final String level = etLevel.getText().toString();

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getActivity(), "Data Users berhasil diupdate!", Toast.LENGTH_SHORT).show();
                                startActivity(getActivity().getIntent());
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(), "error " + error, Toast.LENGTH_LONG).show();
                                startActivity(getActivity().getIntent());
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("q", "update");
                                params.put("who", "admin");
                                params.put("table", "users");
                                params.put("id", id);
                                params.put("username", username);
                                params.put("email", email);
                                params.put("password", password);
                                params.put("score", score);
                                params.put("level", level);
                                return params;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                        requestQueue.add(stringRequest);
                    }
                });

                builderEditUsers.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builderEditUsers.show();
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
                params.put("q", "getById");
                params.put("table", "users");
                params.put("id", String.valueOf(id));
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}