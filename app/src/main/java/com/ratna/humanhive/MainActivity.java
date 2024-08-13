package com.ratna.humanhive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnBasicHumanList, btnCustomListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnBasicHumanList = findViewById(R.id.btn_basic_human_list);
        btnCustomListView = findViewById(R.id.btn_custom_listview);

        btnBasicHumanList.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BasicListViewActivity.class);
            startActivity(intent);
        });

        btnCustomListView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CustomListActivity.class);
            startActivity(intent);
        });

    }
}