package com.example.eatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import utils.ServiceConnection;

public class LoginActivity extends AppCompatActivity {


    private TextView nameSurname;
    private TextView username;
    private TextView password;
    private TextView email;
    private TextView userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameSurname = findViewById(R.id.nameSurname);
        username = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        userType = findViewById(R.id.userType);
    }

    private void sendWorkPostRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        Map<String, String> params = new HashMap<String, String>();

        params.put("nameSurname", nameSurname.getText().toString());
        params.put("username", username.getText().toString());
        params.put("password", password.getText().toString());
        params.put("email", email.getText().toString());
        params.put("userType", userType.getText().toString());

        Log.d("registerRequest", params.toString());

        final JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.POST, ServiceConnection.getInstance(this).url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("response", "response message is: " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                return headers;
            }
        };
        queue.add(jsonObject);
    }

    public void register(View view){
        sendWorkPostRequest();
    }

}