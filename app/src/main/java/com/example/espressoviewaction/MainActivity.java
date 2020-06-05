package com.example.espressoviewaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String COUNT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button single = findViewById(R.id.single);
        single.setOnClickListener(v -> {
            Intent intent = new Intent(this, SingleLongClickActivity.class);
            startActivity(intent);
        });
        Button continuous = findViewById(R.id.continuous);
        continuous.setOnClickListener(v -> {
            Intent intent = new Intent(this, ContinuousLongClickActivity.class);
            startActivity(intent);
        });
    }
}
