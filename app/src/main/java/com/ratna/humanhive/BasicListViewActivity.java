package com.ratna.humanhive;

import android.os.Bundle;
import android.view.PixelCopy;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BasicListViewActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basic_list_view);

        listView = findViewById(R.id.basicList);
//        data = new ArrayList<String>();
//        data.add("Ramesh");
//        data.add("Suresh");
//        data.add("Mohan");
//        data.add("Rajesh");


        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            String name = data.get(position);
            Toast.makeText(BasicListViewActivity.this, name, Toast.LENGTH_SHORT).show();
        });
        fetchHuman();

    }

    void fetchHuman() {
        String url = "https://randomuser.me/api/?results=30";
        RequestQueue requestQueue = Volley.newRequestQueue(BasicListViewActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);
                                String gender = result.getString("gender");
                                JSONObject nameObj = result.getJSONObject("name");
                                String title = nameObj.getString("title");
                                String firstName = nameObj.getString("first");
                                String lastName = nameObj.getString("last");

                                String fullName = title + " " + firstName + " " + lastName;
                                data.add(fullName);


                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(BasicListViewActivity.this, android.R.layout.simple_list_item_1, data);
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }
}