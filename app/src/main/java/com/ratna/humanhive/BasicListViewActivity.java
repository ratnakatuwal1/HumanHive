package com.ratna.humanhive;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
        data = new ArrayList<String>();
        data.add("Ramesh");
        data.add("Suresh");
        data.add("Mohan");
        data.add("Rajesh");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(BasicListViewActivity.this, R.layout.item_basic_list, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
           String name = data.get(position);
            Toast.makeText(BasicListViewActivity.this, name, Toast.LENGTH_SHORT).show();
        });

    }
}