package com.example.espressoviewaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.espressoviewaction.MainActivity.COUNT;

public class ContinuousLongClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_click);
        TextView textView = findViewById(R.id.text);
        final int count;
        if (getIntent().hasExtra(COUNT)) {
            count = getIntent().getIntExtra(COUNT, 0) + 1;
        } else {
            count = 0;
        }
        textView.setText(String.valueOf(count));
        textView.setOnLongClickListener(v -> {
            Intent intent = new Intent(this, ContinuousLongClickActivity.class);
            intent.putExtra(COUNT, count);
            startActivity(intent);
            return true;
        });
    }
}
