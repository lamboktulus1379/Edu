package com.danmogot.edunsi100;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.danmogot.edunsi100.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminTable extends Fragment implements View.OnClickListener {

    View view;

    String id, username, email, password;
    String usernameEdit = null, emailEdit = null, passwordEdit = null;

    TableLayout tlAdmin;

    ArrayList<Button> btnEditAdmin = new ArrayList<Button>();
    ArrayList<Button> btnDeleteAdmin = new ArrayList<Button>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.table_admin, container, false);

        initViews();

        final TableRow trAdmin = new TableRow(getActivity());
        TextView tvHeaderId = new TextView(getActivity());
        TextView tvHeaderUsername = new TextView(getActivity());
        TextView tvHeaderEmail = new TextView(getActivity());
        TextView tvHeaderPassword = new TextView(getActivity());

        tvHeaderId.setText("ID");
        tvHeaderUsername.setText("Username");
        tvHeaderEmail.setText("Email");
        tvHeaderPassword.setText("Password");

        tvHeaderId.setPadding(5, 1, 5, 1);
        tvHeaderUsername.setPadding(5, 1, 5, 1);
        tvHeaderEmail.setPadding(5, 1, 5, 1);
        tvHeaderPassword.setPadding(5, 1, 5, 1);

        trAdmin.addView(tvHeaderId);
        trAdmin.addView(tvHeaderUsername);
        trAdmin.addView(tvHeaderEmail);
        trAdmin.addView(tvHeaderPassword);

        tlAdmin.addView(trAdmin, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

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


                        TableRow trAdmin = new TableRow(getActivity());

                        if (i % 2 == 0) {
                            trAdmin.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        }

                        TextView tvId = new TextView(getActivity());
                        tvId.setText(id);
                        tvId.setPadding(5, 5, 1, 5);
                        trAdmin.addView(tvId);

                        TextView tvUsername = new TextView(getActivity());
                        tvUsername.setText(username);
                        tvUsername.setPadding(5, 5, 1, 5);
                        trAdmin.addView(tvUsername);

                        TextView tvEmail = new TextView(getActivity());
                        tvEmail.setText(email);
                        tvEmail.setPadding(5, 5, 1, 5);
                        trAdmin.addView(tvEmail);

                        TextView tvPassword = new TextView(getActivity());
                        tvPassword.setText(password);
                        tvPassword.setPadding(5, 5, 1, 5);
                        trAdmin.addView(tvPassword);


                        btnEditAdmin.add(i, new Button(getActivity()));
                        btnEditAdmin.get(i).setId(Integer.parseInt(id));
                        btnEditAdmin.get(i).setTag("Edit");
                        btnEditAdmin.get(i).setText("Edit");
                        btnEditAdmin.get(i).setOnClickListener(AdminTable.this);
                        trAdmin.addView(btnEditAdmin.get(i));

                        btnDeleteAdmin.add(i, new Button(getActivity()));
                        btnDeleteAdmin.get(i).setId(Integer.parseInt(id));
                        btnDeleteAdmin.get(i).setTag("Delete");
                        btnDeleteAdmin.get(i).setText("Delete");
                        btnDeleteAdmin.get(i).setOnClickListener(AdminTable.this);
                        trAdmin.addView(btnDeleteAdmin.get(i));

                        tlAdmin.addView(trAdmin, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


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
                params.put("table", "admin");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

        return view;
    }

    public void initViews() {
        tlAdmin = view.findViewById(R.id.tlAdmin);
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < btnEditAdmin.size(); i++) {
            if (v.getId() == btnEditAdmin.get(i).getId() && v.getTag().toString().trim().equals("Edit")) {

                int id = btnEditAdmin.get(i).getId();
                getAdminById(id);
            } else if (v.getId() == btnDeleteAdmin.get(i).getId() && v.getTag().toString().trim().equals("Delete")) {
                int id = btnDeleteAdmin.get(i).getId();
                deleteAdmin(id);
            }
        }
    }

    public void deleteAdmin(final int id) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
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
                params.put("table", "admin");
                params.put("id", String.valueOf(id));
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    public void getAdminById(final int id) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    usernameEdit = jsonObject.getString("username");
                    passwordEdit = jsonObject.getString("password");
                    emailEdit = jsonObject.getString("email");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LinearLayout llInputEdit = new LinearLayout(getActivity());
                llInputEdit.setOrientation(LinearLayout.VERTICAL);

                final TextView tvId = new TextView(getActivity());
                tvId.setText(String.valueOf(id));
                tvId.setTextColor(Color.TRANSPARENT);
                llInputEdit.addView(tvId);

                final EditText etUsername = new EditText(getActivity());
                etUsername.setText(usernameEdit);
                llInputEdit.addView(etUsername);

                final EditText etEmail = new EditText(getActivity());
                etEmail.setText(emailEdit);
                llInputEdit.addView(etEmail);

                final EditText etPassword = new EditText(getActivity());
                etPassword.setText(passwordEdit);
                llInputEdit.addView(etPassword);

                AlertDialog.Builder builderEditAdmin = new AlertDialog.Builder(getActivity());
                builderEditAdmin.setIcon(R.drawable.ic_edit_primary_24dp);
                builderEditAdmin.setTitle("Update Admin");
                builderEditAdmin.setView(llInputEdit);
                builderEditAdmin.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String id = tvId.getText().toString();
                        final String username = etUsername.getText().toString();
                        final String email = etEmail.getText().toString();
                        final String password = etPassword.getText().toString();

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://helenfrisely.000webhostapp.com/edunsi.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getActivity(), "Data Admin berhasil diupdate!", Toast.LENGTH_SHORT).show();
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
                                params.put("table", "admin");
                                params.put("id", id);
                                params.put("username", username);
                                params.put("email", email);
                                params.put("password", password);
                                return params;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                        requestQueue.add(stringRequest);
                    }
                });

                builderEditAdmin.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builderEditAdmin.show();
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
                params.put("table", "admin");
                params.put("id", String.valueOf(id));
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


    }
}
